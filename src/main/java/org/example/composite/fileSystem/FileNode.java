package org.example.composite.fileSystem;

public class FileNode extends FileSystemNode{
    private long size;
    public FileNode(String name, long size) {
        super(name);
        this.size=size;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent+"- "+this.name);
    }

    @Override
    public int countFiles() {
        return 1;
    }

    @Override
    public FileSystemNode deepCopy() {
        return new FileNode(this.name,this.size);
    }
}
