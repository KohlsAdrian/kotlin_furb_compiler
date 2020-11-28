package components

import compiler.*
import java.awt.FileDialog
import java.awt.Frame
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection
import java.io.*
import java.lang.Exception
import javax.swing.*
import javax.swing.table.DefaultTableModel
import javax.swing.text.Utilities

enum class ERRORTYPE {
    LEXICAL,
    SYNTATIC,
    SEMANTIC,
}

class EditorCompiler(private val jTextArea: JTextArea, private val jTable: JTable, private val jLabel: JLabel) {
    private var isFileNew = true
    private var mDir: String? = ""
    private var mFile: String? = ""
    fun new() {
        jTextArea.text = ""
        jLabel.text = ""
        (jTable.model as DefaultTableModel).rowCount = 0
        isFileNew = true
        clearTableMessages()
    }

    fun open() {
        val dialog = FileDialog(null as Frame?, "Selecione um arquivo TXT")
        dialog.mode = FileDialog.LOAD
        dialog.filenameFilter = FilenameFilter { _, name -> name.toLowerCase().endsWith(".txt") }
        dialog.isVisible = true
        val file = dialog.file
        if (file != null) {
            val dir = dialog.directory
            val path = "$dir$file"
            jTextArea.text = ""
            (jTable.model as DefaultTableModel).rowCount = 0
            try {
                val fileReader = FileReader(path)
                val bufferedReader = BufferedReader(fileReader)
                val lines = bufferedReader.readLines().toList()

                for (line in lines) {
                    jTextArea.append(line)
                    if (lines[lines.count() - 1] != line)
                        jTextArea.append("\n")
                }

                bufferedReader.close()

                clearTableMessages()

                jLabel.text = path
                isFileNew = false

                mDir = dir
                mFile = file
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun save() {
        if (isFileNew) {
            val fileDialog = FileDialog(JFrame(), "Salvar", FileDialog.SAVE)
            fileDialog.file = "Novo arquivo.txt"
            fileDialog.filenameFilter = FilenameFilter { _, name -> name.toLowerCase().endsWith(".txt") }
            fileDialog.isVisible = true
            if (fileDialog.file != null) {
                mDir = fileDialog.directory
                mFile = if (!fileDialog.file.endsWith(".txt"))
                    "${fileDialog.file}.txt"
                else
                    fileDialog.file

                if (mDir != null && mFile != null)
                    saveFile(mDir, mFile)

                isFileNew = false
            }
        } else
            saveFile(mDir, mFile)

    }

    private fun saveFile(dir: String?, file: String?) {
        val lines = jTextArea.text.split("\\n")
        val path = if (isFileNew) "$dir$file" else "$mDir$mFile"
        val mFile = File(path)
        try {
            if (isFileNew)
                mFile.createNewFile()

            val f = FileOutputStream(mFile)
            val h = DataOutputStream(f)

            for (l in lines)
                h.writeBytes(l)

            h.close()
            f.close()

            jLabel.text = path
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


    fun copy() {
        val selectedText = if (jTextArea.selectedText != null)
            jTextArea.selectedText
        else ""

        val selection = StringSelection(selectedText)
        val clipboard: Clipboard = Toolkit.getDefaultToolkit().systemClipboard
        clipboard.setContents(selection, null)
    }

    fun paste() {
        val clipboard: Clipboard = Toolkit.getDefaultToolkit().systemClipboard
        val selectedText = clipboard.getData(DataFlavor.stringFlavor) as String
        jTextArea.insert(selectedText, jTextArea.caretPosition)
    }

    fun cut() {
        copy()
        jTextArea.replaceSelection("")
    }

    private fun clearTableMessages() {
        val model = (jTable.model as JConsoleTableModel)
        model.clear()
    }

    fun compile() {

        try {
            clearTableMessages()

            val lexico = Lexico()
            val sintatico = Sintatico()
            val semantico = Semantico()

            lexico.setInput(jTextArea.text)

            sintatico.parse(lexico, semantico)

            val compiled = semantico.getCompiled()
            val code = semantico.getCode()
            val dir = if(mDir?.length == 0) System.getProperty("user.dir") else mDir
            try {
                val file = if(mFile?.length == 0) "/compiler.txt" else mFile
                val mFile = File("$dir$file")
                mFile.delete()
                mFile.createNewFile()

                val f = FileOutputStream(mFile)
                val h = DataOutputStream(f)

                h.writeBytes(code)

                h.close()
                f.close()

            } catch (e: IOException) {
                e.printStackTrace()
            }
            try {
                val file = if(mFile?.length == 0) "/compiler.il" else mFile
                val mFile = File("$dir$file")
                mFile.delete()
                mFile.createNewFile()

                val f = FileOutputStream(mFile)
                val h = DataOutputStream(f)

                h.writeBytes(compiled)

                h.close()
                f.close()

            } catch (e: IOException) {
                e.printStackTrace()
            }
            //save in file txt

            jLabel.text = "programa compilado com sucesso"
        } catch (e: LexicalError) {
            val pos = e.position
            val msg = e.message
            consoleShowMessage(pos, msg, "erro léxico ao compilar programa", ERRORTYPE.LEXICAL)
        } catch (e: SyntaticError) {
            val pos = e.position
            val msg = e.message
            consoleShowMessage(pos, msg, "erro sintático ao compilar programa", ERRORTYPE.SYNTATIC)
        } catch (e: SemanticError) {
            val pos = e.position
            val msg = e.message
            consoleShowMessage(pos, msg, "erro semântico ao compilar programa", ERRORTYPE.SEMANTIC)
        } catch (e: Exception){
            jLabel.text = "$e"
        }
    }

    private fun consoleShowMessage(pos: Int, error: String?, message: String, errorType: ERRORTYPE) {
        val model = (jTable.model as JConsoleTableModel)

        val line = jTextArea.getLineOfOffset(pos)

        val wordStart = Utilities.getWordStart(jTextArea, pos)
        val wordEnd = Utilities.getWordEnd(jTextArea, pos)

        val symbol = jTextArea.getText(pos, wordEnd - wordStart)

        val messageConv = when (errorType) {
            ERRORTYPE.LEXICAL -> EditorCompilerUtils.getLexicalError(error, symbol, null)
            ERRORTYPE.SYNTATIC -> EditorCompilerUtils.getSyntaticError(error, symbol)
            ERRORTYPE.SEMANTIC -> "Erro semântico não implementando"
        }

        val jCompilerMessage = JCompilerMessage(line + 1, "Erro", messageConv)
        model.addRowJcompilerMessage(jCompilerMessage)
        jLabel.text = message

    }

    fun showTeam() = JOptionPane.showMessageDialog(
        null,
        "Adrian Kohls",
        "Equipe",
        JOptionPane.INFORMATION_MESSAGE,
        ImageIcon(javaClass.classLoader.getResource("team.png")),
    )
}