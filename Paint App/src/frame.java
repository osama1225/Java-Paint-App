import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class frame extends JFrame  {

	private JButton Square, Circle, Ellipse, rectangle, triangle, line, delete,
			colorChooser, move, resize, changeC;
	private JRadioButton filled, border;
	protected static String url;
	MouseClass paint;
	private XmlFile xf;
	private Jsonfile jf;
	private JFileChooser SLfile;
	private JMenuBar bar;
	private JMenu file;
	private JMenu edit;
	private JMenu save;
	private JMenu load;
	private JMenuItem xml;
	private JMenuItem jason;
	private JMenuItem xfile;
	private JMenuItem jfile;
	private JMenuItem undo;
	private JMenuItem redo;
	private JPanel Bshapes;
	private boolean PressedUndo;

	public frame() {

		PressedUndo = false;
		url = "";
		paint = new MouseClass();
		setSize(990, 770);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		xml = new JMenuItem("As Xml");
		jason = new JMenuItem("As Json");
		xfile = new JMenuItem("xml file");
		jfile = new JMenuItem("Json file");
		undo = new JMenuItem("Undo");
		redo = new JMenuItem("Redo");
		edit = new JMenu("Edit");
		edit.add(undo);
		edit.add(redo);
		save = new JMenu("save");
		save.add(xml);
		save.add(jason);
		load = new JMenu("load");
		load.add(xfile);
		load.add(jfile);
		file = new JMenu("File");
		file.add(save);
		file.add(load);
		bar = new JMenuBar();
		bar.add(file);
		bar.add(edit);
		bar.setBounds(0, 0, 1200, 20);

		add(bar);

		Square=new JButton(new ImageIcon("square.png"));
		Square.setBounds(0,80,40,40);
		triangle=new JButton(new ImageIcon("triangle.png"));
		triangle.setBounds(45, 80, 40, 40);
		line=new JButton(new ImageIcon("line.png"));
		line.setBounds(0, 125, 40, 40);
		rectangle=new JButton(new ImageIcon("rectangle.png"));
		rectangle.setBounds(45, 125, 40, 40);
		Ellipse=new JButton(new ImageIcon("ellipse.png"));
		Ellipse.setBounds(0,170,40,40);
		Circle=new JButton(new ImageIcon("circle.png"));
		Circle.setBounds(45, 170, 40, 40);

		Bshapes = new JPanel();
		Bshapes.setLayout(null);
		Bshapes.setBounds(0, 0, 90, 850);
		Bshapes.add(Square);
		Bshapes.add(triangle);
		Bshapes.add(line);
		Bshapes.add(rectangle);
		Bshapes.add(Ellipse);
		Bshapes.add(Circle);
		add(Bshapes);

		move=new JButton(new ImageIcon("move.png"));
		move.setToolTipText("move");
		move.setBounds(0, 400,40 ,40);
		resize=new JButton(new ImageIcon("resize.png"));
		resize.setToolTipText("resize");
		resize.setBounds(45, 400, 40, 40);
        delete=new JButton(new ImageIcon("delete.png"));
        delete.setToolTipText("delete");
        delete.setBounds(0,445,40,40);
		changeC=new JButton(new ImageIcon("changeColor.jpg"));
		changeC.setBounds(45, 445, 40, 40);
		changeC.setToolTipText("change color");
		colorChooser=new JButton(new ImageIcon("colorChooser.jpg"));
		colorChooser.setBounds(0, 490, 85, 80);
		colorChooser.setToolTipText("choose color");
		filled = new JRadioButton("filled");
		filled.setBounds(0, 600, 60, 20);
		border = new JRadioButton("border");
		border.setBounds(0, 640, 70, 20);
		Bshapes.add(move);
		Bshapes.add(resize);
		Bshapes.add(delete);
		Bshapes.add(changeC);
		Bshapes.add(colorChooser);
		Bshapes.add(filled);
		Bshapes.add(border);

		paint.setBounds(85, 25, 1005, 700);
		add(paint);
		xf = new XmlFile();
		jf = new Jsonfile();

		xml.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int retval = 0;
				FileChooserSave(retval);
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
						xf.save(paint.currentShapes);
					} catch (Exception e1) {
					}
				}
			}
		});
		
		xfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int retval = 0;
				OpenFile(retval);
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
						xf.load(paint.shapes, paint.currentShapes,
								paint.ur.undo, paint.ur.lastaction);
						paint.repaint();
					} catch (Exception e1) {
					}
				}
			}
		});

		jason.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int retval = 0;
				FileChooserSave(retval);
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
						jf.save(paint.currentShapes);
					} catch (Exception e1) {
					}
				}
			}
		});
		
		jfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int retval = 0;

				OpenFile(retval);
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
						jf.load(paint.currentShapes, paint.shapes,
								paint.ur.undo, paint.ur.lastaction);
						paint.repaint();
					} catch (Exception e1) {
					}
				}
			}

		});
		
		undo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					if (paint.ur.undo.isEmpty()) {
					} else {
						PressedUndo = true;
						paint.ur.undo(paint.currentShapes);
						paint.repaint();
					}
				} catch (Exception e2) {
				}
			}
		});
		
		redo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (PressedUndo == true && !paint.ur.redo.isEmpty()&&!paint.ur.undo.isEmpty()) {
					paint.ur.redo(paint.currentShapes);
					paint.repaint();
				} else {
				}
			}
		});

		resize.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				paint.flag = 5;
				PressedUndo = false;

			}
		});

		move.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				paint.flag = 6;
				PressedUndo = false;
			}
		});
		
		Ellipse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 1;
				PressedUndo = false;
			}
		});
		
		Circle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 7;
				PressedUndo = false;
			}
		});

		rectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 2;
				PressedUndo = false;
			}
		});
		
		Square.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 8;
				PressedUndo = false;
			}
		});

		triangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 3;
				PressedUndo = false;
			}
		});

		line.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 4;
				PressedUndo = false;
			}
		});

		colorChooser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.color = JColorChooser.showDialog(paint, "Choose a color",
						paint.color);
				PressedUndo = false;
			}
		});

		changeC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.flag = 9;
				PressedUndo = false;
			}
		});

		filled.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.isFilled = true;
				PressedUndo = false;
				border.setSelected(false);
			}
		});

		border.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paint.isFilled = false;
				PressedUndo = false;
				filled.setSelected(false);
			}
		});

		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PressedUndo = false;
				paint.flag = 10;
			}
		});

	}

	private void OpenFile(int retval) {
		SLfile = new JFileChooser();
		retval = SLfile.showOpenDialog(null);
		SLfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		SLfile.setBackground(Color.white);
	}

	private void FileChooserSave(int retval) {
		SLfile = new JFileChooser();
		retval = SLfile.showSaveDialog(null);
		SLfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		SLfile.setBackground(Color.white);
	}

	public static void main(String[] args) {
		try {
			frame f = new frame();
			f.setVisible(true);
		} catch (Exception e) {
			System.out.println("unexpected error");
		}
	}

}
