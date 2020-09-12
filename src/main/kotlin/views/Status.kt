package views

import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.BoxLayout
import javax.swing.JLabel
import javax.swing.JPanel

class Status(jLabel: JLabel) : JPanel() {

    init {
        size = Dimension(900, 30)
        minimumSize = size
        preferredSize = size
        maximumSize = Dimension(Int.MAX_VALUE, 30)

        layout = BoxLayout(this, BoxLayout.LINE_AXIS)
        jLabel.minimumSize = size
        jLabel.preferredSize = size
        add(jLabel)
    }
}