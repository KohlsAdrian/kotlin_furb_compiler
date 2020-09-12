package views

import components.EditorCompiler
import java.awt.Dimension
import java.awt.Image
import javax.imageio.ImageIO
import javax.swing.*


class Header(editorCompiler: EditorCompiler) : JPanel() {

    private val jButtonNew = JButton("Novo [ctrl-n]")
    private val jButtonOpen = JButton("Abrir [ctrl-o]")
    private val jButtonSave = JButton("Salvar [ctrl-s]")
    private val jButtonCopy = JButton("Copiar [ctrl-c]")
    private val jButtonPaste = JButton("Colar [ctrl-v]")
    private val jButtonCut = JButton("Recortar [ctrl-x]")
    private val jButtonCompile = JButton("Compilar [F9]")
    private val jButtonTeam = JButton("Equipe [F1]")

    private fun setButtonImageAndLayout(button: JButton, image: Image) {
        button.size = Dimension((900 / 8), 70)
        button.minimumSize = button.size
        button.maximumSize = button.size
        button.preferredSize = button.size
        button.verticalTextPosition = SwingConstants.BOTTOM
        button.horizontalTextPosition = SwingConstants.CENTER
        isFocusable = true
        button.horizontalAlignment = SwingConstants.CENTER
        button.verticalAlignment = SwingConstants.TOP

        button.icon = ImageIcon(image.getScaledInstance(36, 36, Image.SCALE_SMOOTH))
    }

    init {
        layout = BoxLayout(this, BoxLayout.LINE_AXIS)

        size = Dimension(900, 70)
        minimumSize = size
        preferredSize = minimumSize
        maximumSize = Dimension(Int.MAX_VALUE, 70)


        val cl = javaClass.classLoader
        setButtonImageAndLayout(jButtonNew, ImageIO.read(cl.getResource("new.png")))
        setButtonImageAndLayout(jButtonOpen, ImageIO.read(cl.getResource("open.png")))
        setButtonImageAndLayout(jButtonSave, ImageIO.read(cl.getResource("save.png")))
        setButtonImageAndLayout(jButtonCopy, ImageIO.read(cl.getResource("copy.png")))
        setButtonImageAndLayout(jButtonPaste, ImageIO.read(cl.getResource("paste.png")))
        setButtonImageAndLayout(jButtonCut, ImageIO.read(cl.getResource("cut.png")))
        setButtonImageAndLayout(jButtonCompile, ImageIO.read(cl.getResource("compile.png")))
        setButtonImageAndLayout(jButtonTeam, ImageIO.read(cl.getResource("team.png")))

        jButtonNew.addActionListener { editorCompiler.new() }
        jButtonOpen.addActionListener { editorCompiler.open() }
        jButtonSave.addActionListener { editorCompiler.save() }
        jButtonCopy.addActionListener { editorCompiler.copy() }
        jButtonPaste.addActionListener { editorCompiler.paste() }
        jButtonCut.addActionListener { editorCompiler.cut() }
        jButtonCompile.addActionListener { editorCompiler.compile() }
        jButtonTeam.addActionListener { editorCompiler.showTeam() }

        add(jButtonNew)
        add(jButtonOpen)
        add(jButtonSave)
        add(jButtonCopy)
        add(jButtonPaste)
        add(jButtonCut)
        add(jButtonCompile)
        add(jButtonTeam)
    }
}