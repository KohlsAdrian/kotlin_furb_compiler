package components

import compiler.LexicalError
import compiler.Lexico
import compiler.Token
import java.awt.FileDialog
import java.awt.Frame
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection
import java.io.*
import javax.swing.*
import javax.swing.table.DefaultTableModel


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
        clearTableMessages()
        val model = (jTable.model as JConsoleTableModel)

        val lexico = Lexico()
        lexico.setInput(jTextArea.text)
        var t: Token?
        var lastToken: Token? = null
        try {
            t = lexico.nextToken()
            if (t != null)
                lastToken = t

            val jCompilerMessages = arrayListOf<JCompilerMessage>()

            while (t != null) {
                val id = t.id
                val mClass = EditorCompilerUtils.getClassById(id)
                val lexeme = t.lexeme
                val pos = t.position
                val line = jTextArea.getLineOfOffset(pos)

                jCompilerMessages.add(JCompilerMessage(line + 1, mClass, lexeme))

                t = lexico.nextToken()
            }

            for (message in jCompilerMessages)
                model.addRowJcompilerMessage(message)

        } catch (e: LexicalError) {
            val pos = e.position
            val line = jTextArea.getLineOfOffset(pos)
            val symbol = jTextArea.getText(pos, 1)
            val lexeme = lastToken?.lexeme
            val msg = e.message

            val message = EditorCompilerUtils.getCompilerError(msg, symbol, lexeme)

            val jCompilerMessage = JCompilerMessage(line + 1, "Erro", message)
            model.addRowJcompilerMessage(jCompilerMessage)
        }
    }

    fun showTeam() = JOptionPane.showMessageDialog(
        null,
        "Adrian Kohls",
        "Equipe",
        JOptionPane.INFORMATION_MESSAGE,
        ImageIcon(javaClass.classLoader.getResource("team.png")),
    )
}