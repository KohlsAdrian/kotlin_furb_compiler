package components

import javax.swing.table.DefaultTableModel

class JConsoleTableModel : DefaultTableModel() {
    private val messages = arrayListOf<JCompilerMessage>()

    init {
        val mColumns = arrayOf("Linha", "Classe", "Lexema")
        for (column in mColumns)
            addColumn(column)
    }

    fun clear() {
        messages.clear()
        if (rowCount > 0)
            for (i in 0 until rowCount) removeRow(0)
    }

    fun addRowJcompilerMessage(jCompilerMessage: JCompilerMessage) {
        messages.add(jCompilerMessage)
        val line = jCompilerMessage.line
        val error = jCompilerMessage.location
        val msg = jCompilerMessage.description
        addRow(arrayOf(line, error, msg))
    }

    override fun isCellEditable(rowIndex: Int, columnIndex: Int): Boolean = false

    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any? {
        val jCompilerError = messages[rowIndex]
        return when (columnIndex) {
            0 -> jCompilerError.line
            1 -> jCompilerError.location
            2 -> jCompilerError.description
            else -> null
        }
    }


}