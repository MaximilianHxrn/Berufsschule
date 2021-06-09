import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * ToDo-List with Entry.
 *
 * @author <a href="mailto:horn@singhammer.com">Maximilian Horn<>/a>
 * @version $Revision: 1703 $
 */
public class ToDoListEntry extends JFrame {

   private class Entry {
      public String besch = "";
      public int anz = 0;

      public Entry(String beschreibung, int anzahl) {
         besch = beschreibung;
         anz = anzahl;
      }

      /** quick and dirty with monospaced font */
      @Override
      public String toString() {
         return (besch + "                                                                   ").substring(0, 40) + " "
               + anz;
      }
   }

   private class Controller extends AbstractListModel<Entry> {
      private ArrayList<Entry> entries;
      File file;

      public Controller(String fileName) {
         super();
         entries = new ArrayList<>();
         file = new File(fileName);
      }

      void add(Entry e) {
         entries.add(e);
         updateFrame();
      }

      void updateFrame() {
         try {
            list.updateUI();
         } catch (Exception exc) {
            exc.printStackTrace();
         }
      }

      public void save() throws FileNotFoundException, UnsupportedEncodingException {
         PrintWriter writer = new PrintWriter(file.getAbsolutePath(), "UTF-8");
         for (int i = 0; i < entries.size(); i++) {
            writer.write(entries.get(i) + "\n");
         }
         writer.close();
      }

      void load() {
         if (file.exists()) {
            try {
               BufferedReader br = new BufferedReader(new FileReader(file));
               String st;
               while ((st = br.readLine()) != null) {
                  if (!st.isEmpty()) {
                     st = st.replaceAll("\\s+", "");
                     Entry entry = new Entry(st.substring(0, st.length() - 2),
                           Integer.parseInt(Character.toString((st.charAt(st.length() - 1)))));
                     add(entry);
                  }
               }
               br.close();
            } catch (FileNotFoundException e) {
               e.printStackTrace();
            } catch (IOException e1) {
               e1.printStackTrace();
            }
            updateFrame();
         }
      }

      void removeAt(int index) {
         entries.remove(index);
         updateFrame();
      }

      void removeAll() {
         entries.clear();
         updateFrame();
      }

      @Override
      public int getSize() {
         return entries.size();
      }

      @Override
      public Entry getElementAt(int index) {
         return entries.get(index);
      }
   }

   /** main */
   public static void main(final String[] args) {
      new ToDoListEntry();
   }

   private Controller controller = new Controller("todo.txt");
   private JList<Entry> list = new JList<>(controller);
   private final JTextField tfb;
   private final JTextField tfa;
   private final Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);

   /** Create a new object */
   public ToDoListEntry() {

      super();

      // title
      setTitle("ToDo-List with Entry");

      // window listener
      addWindowListener(new WindowAdapter() {

         @Override
         public void windowClosing(final WindowEvent e) {
            try {
               exit();
            } catch (FileNotFoundException e1) {
               e1.printStackTrace();
            } catch (UnsupportedEncodingException e1) {
               e1.printStackTrace();
            }
         }
      });

      // container for components and so on.
      final Container con = getContentPane();

      // layout
      con.setLayout(new BorderLayout());

      // list ...
      list = new JList<>(controller);
      list.setFont(font);
      final JScrollPane sp = new JScrollPane(list);
      con.add(sp, BorderLayout.CENTER);

      tfb = new JTextField(35);
      tfa = new JTextField(3);
      final JPanel pt = new JPanel(new FlowLayout(FlowLayout.LEFT));
      pt.add(tfb);
      pt.add(tfa);
      con.add(pt, BorderLayout.NORTH);

      tfb.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(final KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               tfa.requestFocus();
            }
         }
      });
      tfa.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(final KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               addEntry();
            }
         }
      });

      final JPanel p = new JPanel();
      p.setLayout(new GridLayout(0, 1));

      final JButton add = new JButton("add");
      final JButton remove = new JButton("remove");
      final JButton removeAll = new JButton("remove all");
      final JButton exit = new JButton("exit");
      p.add(add);
      p.add(remove);
      p.add(removeAll);
      p.add(exit);
      con.add(p, BorderLayout.EAST);

      // add the action for the buttons
      exit.addActionListener((e) -> {
         try {
            exit();
         } catch (FileNotFoundException | UnsupportedEncodingException e1) {
            e1.printStackTrace();
         }
      });
      add.addActionListener((e) -> addEntry());
      remove.addActionListener((e) -> {
         final int pos = list.getSelectedIndex();
         if (pos >= 0) {
            controller.removeAt(pos);
         }
         tfb.requestFocus();
      });
      removeAll.addActionListener((e) -> {
         controller.removeAll();
         tfb.requestFocus();
      });

      // set the size for the window
      setSize(460, 200);

      // make it visible
      setVisible(true);

      controller.load();
      setLocationRelativeTo(null);
   }

   /** add the entry */
   private void addEntry() {
      if (tfb.getText().trim().length() > 0) {
         int temp;
         try {
            temp = Integer.parseInt(tfa.getText());
         } catch (final NumberFormatException ee) {
            temp = 1;
         }
         final Entry en = new Entry(tfb.getText(), temp);
         controller.add(en);
      }
      tfa.setText("");
      tfb.setText("");
      tfb.requestFocus();
   }

   private void exit() throws FileNotFoundException, UnsupportedEncodingException {
      controller.save();
      System.exit(0);
   }
}