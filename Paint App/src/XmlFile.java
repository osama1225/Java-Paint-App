import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlFile {

	/*
	 * we save each shape as a root elements and its childs are the attributes
	 * of the shape in loading file we use dom parser
	 */

	Ellipse c;
	Triangle t;
	Rectangle r;
	Square s;
	Circle cir;
	Line l;
	Color co;

	public void save(ArrayList<Shape> shapes) throws Exception {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("shapes");
		doc.appendChild(rootElement);

		for (int i = 0; i < shapes.size(); i++) {
			if (((Shape) shapes.get(i)).getName() == "rectangle") {
				Element rectangle = doc.createElement("rectangle");
				rootElement.appendChild(rectangle);

				// xpoint elements
				Element xr = doc.createElement("xr");
				xr.appendChild(doc.createTextNode(""
						+ ((Rectangle) shapes.get(i)).getrX()));
				rectangle.appendChild(xr);

				// ypoint elements
				Element yr = doc.createElement("yr");
				yr.appendChild(doc.createTextNode(""
						+ ((Rectangle) shapes.get(i)).getrY()));
				rectangle.appendChild(yr);

				// Width elements
				Element wr = doc.createElement("wr");
				wr.appendChild(doc.createTextNode(""
						+ ((Rectangle) shapes.get(i)).getrWidth()));
				rectangle.appendChild(wr);

				// hight elements
				Element hr = doc.createElement("hr");
				hr.appendChild(doc.createTextNode(""
						+ ((Rectangle) shapes.get(i)).getrHight()));
				rectangle.appendChild(hr);

				// color elements
				Element color = doc.createElement("color");
				color.appendChild(doc.createTextNode(Integer
						.toString(((Rectangle) shapes.get(i)).getColor()
								.getRGB())));
				rectangle.appendChild(color);

				// filled elements
				Element filled = doc.createElement("filled");
				filled.appendChild(doc.createTextNode(""
						+ ((Rectangle) shapes.get(i)).isFilled()));
				rectangle.appendChild(filled);

			} else if (((Shape) shapes.get(i)).getName() == "square") {
				Element square = doc.createElement("square");
				rootElement.appendChild(square);

				// xpoint elements
				Element xpos = doc.createElement("x");
				xpos.appendChild(doc.createTextNode(""
						+ ((Square) shapes.get(i)).getPosx()));
				square.appendChild(xpos);

				// ypoint elements
				Element ypos = doc.createElement("y");
				ypos.appendChild(doc.createTextNode(""
						+ ((Square) shapes.get(i)).getPosy()));
				square.appendChild(ypos);

				// Width elements
				Element l = doc.createElement("l");
				l.appendChild(doc.createTextNode(""
						+ ((Square) shapes.get(i)).getL()));
				square.appendChild(l);

				// color elements
				Element color = doc.createElement("color");
				color.appendChild(doc.createTextNode(Integer
						.toString(((Square) shapes.get(i)).getColor().getRGB())));
				square.appendChild(color);

				// filled elements
				Element filled = doc.createElement("filled");
				filled.appendChild(doc.createTextNode(""
						+ ((Square) shapes.get(i)).isFilled()));
				square.appendChild(filled);

			} else if (((Shape) shapes.get(i)).getName() == "ellipse") {

				Element Ellipse = doc.createElement("ellipse");
				rootElement.appendChild(Ellipse);

				// xpoint elements
				Element xc = doc.createElement("xc");
				xc.appendChild(doc.createTextNode(""
						+ ((Ellipse) shapes.get(i)).getcX()));
				Ellipse.appendChild(xc);

				// ypoint elements
				Element yc = doc.createElement("yc");
				yc.appendChild(doc.createTextNode(""
						+ ((Ellipse) shapes.get(i)).getcY()));
				Ellipse.appendChild(yc);

				// Width elements
				Element wc = doc.createElement("wc");
				wc.appendChild(doc.createTextNode(""
						+ ((Ellipse) shapes.get(i)).getcWidth()));
				Ellipse.appendChild(wc);

				// hight elements
				Element hc = doc.createElement("hc");
				hc.appendChild(doc.createTextNode(""
						+ ((Ellipse) shapes.get(i)).getcHight()));
				Ellipse.appendChild(hc);

				// color elements
				Element ccolor = doc.createElement("color");
				ccolor.appendChild(doc.createTextNode(Integer
						.toString(((Ellipse) shapes.get(i)).getColor().getRGB())));
				Ellipse.appendChild(ccolor);

				// filled elements
				Element cfilled = doc.createElement("filled");
				cfilled.appendChild(doc.createTextNode(""
						+ ((Ellipse) shapes.get(i)).isFilled()));
				Ellipse.appendChild(cfilled);

			} else if (((Shape) shapes.get(i)).getName() == "circle") {

				Element circle = doc.createElement("circle");
				rootElement.appendChild(circle);

				// xpoint elements
				Element xc = doc.createElement("x");
				xc.appendChild(doc.createTextNode(""
						+ ((Circle) shapes.get(i)).getX()));
				circle.appendChild(xc);

				// ypoint elements
				Element yc = doc.createElement("y");
				yc.appendChild(doc.createTextNode(""
						+ ((Circle) shapes.get(i)).getY()));
				circle.appendChild(yc);

				// Width elements
				Element radius = doc.createElement("radius");
				radius.appendChild(doc.createTextNode(""
						+ ((Circle) shapes.get(i)).getRadius()));
				circle.appendChild(radius);

				// color elements
				Element ccolor = doc.createElement("color");
				ccolor.appendChild(doc.createTextNode(Integer
						.toString(((Circle) shapes.get(i)).getColor().getRGB())));
				circle.appendChild(ccolor);

				// filled elements
				Element cfilled = doc.createElement("filled");
				cfilled.appendChild(doc.createTextNode(""
						+ ((Circle) shapes.get(i)).isFilled()));
				circle.appendChild(cfilled);

			} else if (((Shape) shapes.get(i)).getName() == "line") {

				Element line = doc.createElement("line");
				rootElement.appendChild(line);

				// xpoint elements
				Element x1 = doc.createElement("x1");
				x1.appendChild(doc.createTextNode(""
						+ ((Line) shapes.get(i)).getX1()));
				line.appendChild(x1);

				Element x2 = doc.createElement("x2");
				x2.appendChild(doc.createTextNode(""
						+ ((Line) shapes.get(i)).getX2()));
				line.appendChild(x2);

				Element y1 = doc.createElement("y1");
				y1.appendChild(doc.createTextNode(""
						+ ((Line) shapes.get(i)).getY1()));
				line.appendChild(y1);

				Element y2 = doc.createElement("y2");
				y2.appendChild(doc.createTextNode(""
						+ ((Line) shapes.get(i)).getY2()));
				line.appendChild(y2);

				// color elements
				Element lcolor = doc.createElement("color");
				lcolor.appendChild(doc.createTextNode(Integer
						.toString(((Line) shapes.get(i)).getColor().getRGB())));
				line.appendChild(lcolor);

				// filled elements
				Element lfilled = doc.createElement("filled");
				lfilled.appendChild(doc.createTextNode(""
						+ ((Line) shapes.get(i)).isFilled()));
				line.appendChild(lfilled);

			} else if (((Shape) shapes.get(i)).getName() == "triangle") {

				Element triangle = doc.createElement("triangle");
				rootElement.appendChild(triangle);

				Element x = doc.createElement("x");
				x.appendChild(doc.createTextNode(""
						+ ((Triangle) shapes.get(i)).gettX()));
				triangle.appendChild(x);

				Element y = doc.createElement("y");
				y.appendChild(doc.createTextNode(""
						+ ((Triangle) shapes.get(i)).gettY()));
				triangle.appendChild(y);

				Element xpoints = doc.createElement("xpoints");
				String temp = "" + ((Triangle) shapes.get(i)).getxPoints()[0]
						+ "," + ((Triangle) shapes.get(i)).getxPoints()[1]
						+ "," + ((Triangle) shapes.get(i)).getxPoints()[2];
				xpoints.appendChild(doc.createTextNode(temp));
				triangle.appendChild(xpoints);

				String temp2 = "" + ((Triangle) shapes.get(i)).getyPoints()[0]
						+ "," + ((Triangle) shapes.get(i)).getyPoints()[1]
						+ "," + ((Triangle) shapes.get(i)).getyPoints()[2];
				Element ypoints = doc.createElement("ypoints");
				ypoints.appendChild(doc.createTextNode(temp2));
				triangle.appendChild(ypoints);

				Element tcolor = doc.createElement("color");
				tcolor.appendChild(doc.createTextNode(Integer
						.toString(((Triangle) shapes.get(i)).getColor()
								.getRGB())));
				triangle.appendChild(tcolor);

				// filled elements
				Element tfilled = doc.createElement("filled");
				tfilled.appendChild(doc.createTextNode(""
						+ ((Triangle) shapes.get(i)).isFilled()));
				triangle.appendChild(tfilled);

			}

		}

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(frame.url + ".xml"));
		transformer.transform(source, result);

	}

	public void load(ArrayList<Shape> shapes, ArrayList<Shape> Currentshapes,
			Stack<Item> undo, ArrayList<Integer> lastaction) throws Exception {
		int shapeindex = 0;
		shapes.clear();
		Currentshapes.clear();
		File Xml = new File(frame.url);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(Xml);
		doc.getDocumentElement().normalize();

		NodeList tList = doc.getElementsByTagName("triangle");

		for (int i = 0; i < tList.getLength(); i++) {

			Node tNode = tList.item(i);
			if (tNode != null) {
				if (tNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tNode;
					t = new Triangle();
					t.setName("triangle");
					t.settX(Integer.parseInt(getTagValue("x", eElement)));
					t.settY(Integer.parseInt(getTagValue("y", eElement)));
					t.setxPoints(convert((getTagValue("xpoints", eElement))));
					t.setyPoints(convert((getTagValue("ypoints", eElement))));

					co = new Color(Integer.parseInt(getTagValue("color",
							eElement)));
					t.setColor(co);
					String tempp = getTagValue("filled", eElement);
					if (tempp.charAt(0) == 'f') {
						t.setFilled(false);
					} else {
						t.setFilled(true);
					}
					shapes.add(t);
					Currentshapes.add(t);

					String x = t.getxPoints()[0] + "," + t.getxPoints()[1]
							+ "," + t.getxPoints()[2];
					String y = t.getyPoints()[0] + "," + t.getyPoints()[1]
							+ "," + t.getyPoints()[2];
					undo.push(new Item(shapeindex, "triangle", t.gettX() + ","
							+ t.gettY() + "," + x + "," + y + ","
							+ t.getColor().getRGB() + "," + t.isFilled()));

					lastaction.add(shapeindex);
					shapeindex++;
				}
			}
		}

		NodeList rList = doc.getElementsByTagName("rectangle");

		for (int i = 0; i < rList.getLength(); i++) {

			Node rNode = rList.item(i);
			if (rNode != null) {
				if (rNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) rNode;
					r = new Rectangle();
					r.setName("rectangle");
					r.setrX(Integer.parseInt(getTagValue("xr", eElement)));
					r.setrY(Integer.parseInt(getTagValue("yr", eElement)));
					r.setrWidth(Integer.parseInt(getTagValue("wr", eElement)));
					r.setrHight(Integer.parseInt(getTagValue("hr", eElement)));

					co = new Color(Integer.parseInt(getTagValue("color",
							eElement)));

					r.setColor(co);
					String tempp = getTagValue("filled", eElement);
					if (tempp.charAt(0) == 'f') {
						r.setFilled(false);
					} else {
						r.setFilled(true);
					}

					Currentshapes.add(r);
					shapes.add(r);
					undo.push(new Item(shapeindex, "rectangle", r.getrX() + ","
							+ r.getrY() + "," + r.getrWidth() + ","
							+ r.getrHight() + "," + r.getColor().getRGB() + ","
							+ r.isFilled()));
					lastaction.add(shapeindex);
					shapeindex++;
				}
			}
		}
		NodeList sList = doc.getElementsByTagName("square");

		for (int i = 0; i < sList.getLength(); i++) {

			Node sNode = sList.item(i);
			if (sNode != null) {
				if (sNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) sNode;

					s = new Square();
					s.setName("square");
					s.setPosx(Integer.parseInt(getTagValue("x", eElement)));
					s.setPosy(Integer.parseInt(getTagValue("y", eElement)));
					s.setL(Integer.parseInt(getTagValue("l", eElement)));

					co = new Color(Integer.parseInt(getTagValue("color",
							eElement)));

					s.setColor(co);
					String tempp = getTagValue("filled", eElement);
					if (tempp.charAt(0) == 'f') {
						s.setFilled(false);
					} else {
						s.setFilled(true);
					}

					Currentshapes.add(s);
					shapes.add(s);
					undo.push(new Item(shapeindex, "square", s.getPosx() + ","
							+ s.getPosy() + "," + s.getL() + "," + s.getL()
							+ "," + s.getColor().getRGB() + "," + s.isFilled()));
					lastaction.add(shapeindex);
					shapeindex++;
				}
			}
		}
		NodeList cList = doc.getElementsByTagName("ellipse");

		for (int i = 0; i < cList.getLength(); i++) {

			Node cNode = cList.item(i);

			if (cNode != null) {

				if (cNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) cNode;
					c = new Ellipse();
					c.setName("ellipse");
					c.setcX(Integer.parseInt(getTagValue("xc", eElement)));
					c.setcY(Integer.parseInt(getTagValue("yc", eElement)));
					c.setcWidth(Integer.parseInt(getTagValue("wc", eElement)));
					c.setcHight(Integer.parseInt(getTagValue("hc", eElement)));
					co = new Color(Integer.parseInt(getTagValue("color",
							eElement)));
					c.setColor(co);

					String tempp = getTagValue("filled", eElement);
					if (tempp.charAt(0) == 'f') {
						c.setFilled(false);
					} else {
						c.setFilled(true);
					}

					Currentshapes.add(c);
					shapes.add(c);
					undo.push(new Item(shapeindex, "ellipse", c.getcX() + ","
							+ c.getcY() + "," + c.getcWidth() + ","
							+ c.getcHight() + "," + c.getColor().getRGB() + ","
							+ c.isFilled()));
					lastaction.add(shapeindex);
					shapeindex++;
				}
			}
		}
		NodeList cirList = doc.getElementsByTagName("circle");

		for (int i = 0; i < cirList.getLength(); i++) {

			Node cirNode = cirList.item(i);

			if (cirNode != null) {

				if (cirNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) cirNode;
					cir = new Circle();
					cir.setName("circle");
					cir.setX(Integer.parseInt(getTagValue("x", eElement)));
					cir.setY(Integer.parseInt(getTagValue("y", eElement)));
					cir.setRadius(Integer.parseInt(getTagValue("radius",
							eElement)));
					co = new Color(Integer.parseInt(getTagValue("color",
							eElement)));
					cir.setColor(co);

					String tempp = getTagValue("filled", eElement);
					if (tempp.charAt(0) == 'f') {
						cir.setFilled(false);
					} else {
						cir.setFilled(true);
					}

					Currentshapes.add(cir);
					shapes.add(cir);
					undo.push(new Item(shapeindex, "circle", cir.getX() + ","
							+ cir.getY() + "," + cir.getRadius() + ","
							+ cir.getRadius() + "," + cir.getColor().getRGB()
							+ "," + cir.isFilled()));
					lastaction.add(shapeindex);
					shapeindex++;
				}
			}
		}

		NodeList lList = doc.getElementsByTagName("line");

		for (int i = 0; i < lList.getLength(); i++) {

			Node lNode = lList.item(i);
			if (lNode != null) {
				if (lNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) lNode;
					l = new Line();
					l.setName("line");
					l.setX1(Integer.parseInt(getTagValue("x1", eElement)));
					l.setX2(Integer.parseInt(getTagValue("x2", eElement)));
					l.setY1(Integer.parseInt(getTagValue("y1", eElement)));
					l.setY2(Integer.parseInt(getTagValue("y2", eElement)));
					co = new Color(Integer.parseInt(getTagValue("color",
							eElement)));
					l.setColor(co);

					String tempp = getTagValue("filled", eElement);
					if (tempp.charAt(0) == 'f') {
						l.setFilled(false);
					} else {
						l.setFilled(true);
					}
					Currentshapes.add(l);
					shapes.add(l);
					undo.push(new Item(shapeindex, "line", l.getX1() + ","
							+ l.getY1() + "," + l.getX2() + "," + l.getY2()
							+ "," + l.getColor().getRGB() + "," + l.isFilled()));
					lastaction.add(shapeindex);
					shapeindex++;
				}
			}
		}
	}

	private int[] convert(String a) {

		String[] s = a.split(",");
		int[] array = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			array[i] = Integer.parseInt(s[i]);
		}
		return array;
	}

	// method return the value of the taag

	private String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();

	}

}
