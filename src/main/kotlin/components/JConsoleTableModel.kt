package components

import java.util.*
import javax.swing.table.DefaultTableModel

class JConsoleTableModel(var errors: List<JCompilerError>) : DefaultTableModel() {
    private val COL_LINE = 0
    private val COL_ERROR = 1
    private val COL_DESC = 2

    init {
        val mColumns = arrayOf("Linha", "Erro", "Descrição")
        for (column in mColumns)
            addColumn(column)
        for (error in errors) {
            val v = Vector<JCompilerError>(3, 0)
            v.add(error)
            addRow(v)
        }

    }

    override fun isCellEditable(rowIndex: Int, columnIndex: Int): Boolean = false

    override fun getValueAt(rowIndex: Int, columnIndex: Int): Any? {
        val jCompilerError = errors[rowIndex]
        return when (columnIndex) {
            COL_LINE -> jCompilerError.line
            COL_ERROR -> jCompilerError.error
            COL_DESC -> jCompilerError.description
            else -> null
        }
    }


}