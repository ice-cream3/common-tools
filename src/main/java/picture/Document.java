package picture;

public class Document {

    /**
     * 根节点
     */
    private Element rootElement;

    public static Document createDocument(Element rootElement) {
        Document doc = new Document();
        doc.setRootElement(rootElement);
        return doc;
    }

    public ImageElement getImgRootElement() {
        return (ImageElement) rootElement;
    }

    public Element getRootElement() {
        return rootElement;
    }

    public void setRootElement(Element rootElement) {
        this.rootElement = rootElement;
    }
}
