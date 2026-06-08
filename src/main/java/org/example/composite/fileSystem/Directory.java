package org.example.composite.fileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNode{

    private List<FileSystemNode> children=new ArrayList<>();

    public Directory(String name) {
        super(name);
    }
    public void addChild(FileSystemNode node){
        node.setParent(this);
        children.add(node);
    }
    public void removeChild(FileSystemNode node){
        children.remove(node);
    }
    public List<FileSystemNode> getChildren(){
        return children;
    }

    public FileSystemNode getChild(String name) {

        for (FileSystemNode child : children) {
            if (child.getName().equals(name)) {
                return child;
            }
        }

        return null;
    }

    @Override
    public long getSize() {
        long total=0;

        for(FileSystemNode child : this.children){
            total+=child.getSize();
        }
        return total;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent +"+ "+ this.name);


        for (FileSystemNode child: this.children){
            child.print(indent+"  ");
        }
    }

    @Override
    public int countFiles() {
        int count=0;
        for (FileSystemNode child: this.children){
            count+=child.countFiles();
        }
        return count;
    }

    @Override
    public FileSystemNode deepCopy() {
        Directory copy=new Directory(this.name);
        for (FileSystemNode child:this.children){
            copy.addChild(child.deepCopy());
        }
        return copy;
    }
}
