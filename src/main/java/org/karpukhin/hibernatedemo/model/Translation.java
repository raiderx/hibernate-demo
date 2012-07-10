package org.karpukhin.hibernatedemo.model;

/**
 * @author Pavel Karpukhin
 */
public class Translation {

    private String code;
    private String text;

    /**
     * Default constructor
     */
    public Translation() {
    }

    /**
     * Creates new instance of {@code Translation} with given code and text
     * @param code translation code
     * @param text translation text
     */
    public Translation(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Translation that = (Translation) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }
}
