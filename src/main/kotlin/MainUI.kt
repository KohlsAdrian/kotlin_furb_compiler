import components.EditorCompiler
import components.JCompilerError
import components.JConsoleTableModel
import components.JTextLineNumber
import views.Console
import views.Editor
import views.Header
import views.Status
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.KeyEventDispatcher
import java.awt.KeyboardFocusManager
import java.awt.event.KeyEvent
import javax.swing.*


fun main(args: Array<String>) = EventQueue.invokeLater {
    val jTextArea = JTextArea()
    val jTextLineNumber = JTextLineNumber(jTextArea, 3)
    val jTable = JTable()
    val jLabel = JLabel()

    //gerador de erros de teste no console
    jTable.model = JConsoleTableModel(
        List(100) { index -> JCompilerError(index, "Erro exemplo", "Erro na linha $index") }
    )

    jTable.tableHeader.reorderingAllowed = false
    jTable.columnModel.getColumn(0).minWidth = 50
    jTable.columnModel.getColumn(0).preferredWidth = 50
    jTable.columnModel.getColumn(1).minWidth = 100
    jTable.columnModel.getColumn(1).preferredWidth = 100
    jTable.columnModel.getColumn(2).preferredWidth = 750

    MainUI(jTextArea, jTextLineNumber, jTable, jLabel).isVisible = true
}

class MainUI(jTextArea: JTextArea, jTextLineNumber: JTextLineNumber, jTable: JTable, jLabel: JLabel) :
    JFrame(),
    KeyEventDispatcher {
    private val editorCompiler = EditorCompiler(jTextArea, jTable, jLabel)

    private val jPanelHeader = Header(editorCompiler)
    private val jPanelEditor = Editor(jTextLineNumber, jTextArea)
    private val jPanelConsole = Console(jTable)
    private val jPanelStatus = Status(jLabel)


    init {
        isFocusable = true
        layout = BoxLayout(contentPane, BoxLayout.PAGE_AXIS)
        title = "KOHMPILADOR"
        size = Dimension(900, 600)
        minimumSize = size
        preferredSize = size
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)

        add(jPanelHeader)
        add(jPanelEditor)
        add(jPanelConsole)
        add(jPanelStatus)

        val manager = KeyboardFocusManager.getCurrentKeyboardFocusManager()
        manager.addKeyEventDispatcher(this)

    }

    override fun dispatchKeyEvent(e: KeyEvent?): Boolean {
        if (e != null) {

            if (e.isControlDown && e.id == KeyEvent.KEY_PRESSED)
                when (e.keyCode) {
                    KeyEvent.VK_N -> editorCompiler.new()
                    KeyEvent.VK_O -> editorCompiler.open()
                    KeyEvent.VK_S -> editorCompiler.save()
                    KeyEvent.VK_C -> editorCompiler.copy()
                    KeyEvent.VK_V -> editorCompiler.paste()
                    KeyEvent.VK_X -> editorCompiler.cut()
                }
            else if (e.id == KeyEvent.KEY_PRESSED && e.modifiersEx == 0)
                when (e.keyCode) {
                    KeyEvent.VK_F1 -> editorCompiler.showTeam()
                    KeyEvent.VK_F9 -> editorCompiler.compile()
                }

        }
        return false
    }
}
