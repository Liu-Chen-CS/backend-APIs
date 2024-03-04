package com.actdigital.challenges.mapping.models.db.blocks;

import java.util.Objects;

public class TextBlock extends ArticleBlock {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.text);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj != null && obj.getClass() != this.getClass()) return false;
        TextBlock tb = (TextBlock)obj;
        return (this.getText().equals(tb.getText()));
    }
}
