package views

import java.awt.Dimension
import javax.swing.BoxLayout
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTable

class Console(jTable: JTable) : JPanel() {

    init {
        layout = BoxLayout(this, BoxLayout.LINE_AXIS)
        isFocusable = true

        size = Dimension(900, 100 - 15)
        minimumSize = size
        preferredSize = minimumSize
        maximumSize = Dimension(Int.MAX_VALUE, 100 - 15)

        val jScrollPane = JScrollPane()
        jScrollPane.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        jScrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
        jScrollPane.viewport.add(jTable)

        add(jScrollPane)
    }
}