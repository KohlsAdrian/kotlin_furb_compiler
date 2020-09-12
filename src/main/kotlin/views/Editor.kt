package views

import components.JTextLineNumber
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.BoxLayout
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea
import javax.swing.border.Border
import kotlin.math.min


class Editor(jTextLineNumber: JTextLineNumber, jTextArea: JTextArea) : JPanel() {

    init {
        layout = BorderLayout()
        isFocusable = true

        minimumSize = Dimension(900, 400 - 15)
        preferredSize = minimumSize
        maximumSize = Dimension(Int.MAX_VALUE, Int.MAX_VALUE - 200 - 15)

        val jScrollPane = JScrollPane()
        jScrollPane.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        jScrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS

        jScrollPane.setRowHeaderView(jTextLineNumber)
        jScrollPane.viewport.add(jTextArea)

        add(jScrollPane)
    }
}