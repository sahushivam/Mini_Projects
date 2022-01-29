package model;

public class DocumentWordFrequency {

    int frequency;
    String documentName;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public DocumentWordFrequency(Integer freq, String documentName) {
        this.frequency= freq;
        this.documentName = documentName;
    }
}
