public class SAX {
	/**
	 * 读取 XML.
	 * 
	 * @param String uri XML 存储路径. 
	 * @param String nodeName 节点名称.
	 * @param String fileName 文件名.
	 */
	public void read(String uri, String nodeName, String fileName) {
		//判断 uri, nodeName, filename 合法性

		try {
			SAXParserFactory parserFactory = SAXParserFactory.newInstance(); //反射, parser 工厂实例
			SAXParser parser = parserFactory.newSAXParser(); //反射
			
			//事件处理
			ParseHandler myhandler = new ParseHandler(nodeName, fileName);
			parser.parse(uri, myhandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class ParseHandler extends DefaultHandler {
	private String nodeName = null;
	private String currentTag = null;
	private Article article = new Article();
	private BufferedWriter bufferedWriter = null;
	
	public ParseHandler(String nodeName, String fileName) {
		this.nodeName = nodeName;
		try {
			this.bufferedWriter = new BufferedWriter(new FileWriter(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始解析 XML, 写入 TXT 文档!");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attr) throws SAXException {
		if ("article".equals(qName)) { //从第一个标签开始顺序往下读取
			article.setMDate(attr.getValue(0));
			article.setKey(attr.getValue(1));
		}
		currentTag = qName;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		 if (currentTag != null) {
			 String value = new String(ch, start, length);
			 switch(currentTag) { //判断起始标签
			 	case "author":
			 		article.setAuthor(value);
			 		break;
			 	case "title":
			 		article.setTitle(value);
			 		break;
			 	case "pages":
			 		article.setPages(value);
			 		break;
			 	case "year":
			 		article.setYear(value);
			 		break;
			 	case "volume":
			 		article.setVolume(value);
			 		break;
			 	case "journal":
			 		article.setJournal(value);
			 		break;
			 	case "number":
			 		article.setNumber(value);
			 		break;
			 	case "url":
			 		article.setUrl(value);
			 		break;
			 	case "ee":
			 		article.setEE(value);
			 		break;
			 	default:
			 		break;
			 }
		 }
	}
	
	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		if ("article".equals(qName)) {
			try {
				bufferedWriter.write(article.toString());
				bufferedWriter.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		currentTag = null; //释放节点
	}
	
	@Override
	public void endDocument() throws SAXException {
		if (bufferedWriter != null) {
			try {
				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("XML 文档解析完成，请查看 TXT 文档!");
	}
}