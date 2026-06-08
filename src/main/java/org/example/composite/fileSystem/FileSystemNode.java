package org.example.composite.fileSystem;

public abstract class FileSystemNode {
    protected String name;
    protected Directory parent;

    public FileSystemNode(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }
    public abstract long getSize();
    public abstract void print(String indent);
    public abstract int countFiles();
    public abstract FileSystemNode deepCopy();
}
