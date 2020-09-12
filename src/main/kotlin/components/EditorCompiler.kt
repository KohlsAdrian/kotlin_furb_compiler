package components

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
    private var dir: String? = ""
    private var file: String? = ""
    fun new() {
        jTextArea.text = ""
        jLabel.text = ""
        (jTable.model as DefaultTableModel).rowCount = 0
        isFileNew = true
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

            } catch (e: IOException) {
                e.printStackTrace()
            }
            jLabel.text = path
            isFileNew = false
        }
    }

    fun save() {
        if (isFileNew) {
            val fileDialog = FileDialog(JFrame(), "Salvar", FileDialog.SAVE)
            fileDialog.file = "Novo arquivo.txt"
            fileDialog.filenameFilter = FilenameFilter { _, name -> name.toLowerCase().endsWith(".txt") }
            fileDialog.isVisible = true
            if (fileDialog.file != null) {
                dir = fileDialog.directory
                file = if (!fileDialog.file.endsWith(".txt"))
                    "${fileDialog.file}.txt"
                else
                    fileDialog.file

                if (dir != null && file != null)
                    saveFile(dir, file)

                isFileNew = false
            }
        } else
            saveFile(dir, file)

    }

    private fun saveFile(dir: String?, file: String?) {
        val lines = jTextArea.text.split("\\n")
        val path = "$dir$file"
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


    fun compile() {
        jLabel.text = "compilação de programas ainda não foi implementada"
    }

    fun showTeam() = JOptionPane.showMessageDialog(
        null,
        "Adrian Kohls",
        "Equipe",
        JOptionPane.INFORMATION_MESSAGE,
        ImageIcon(javaClass.classLoader.getResource("team.png")),
    )
}