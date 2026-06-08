package org.example.composite.fileSystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystemService {
    private Directory root=new Directory("root");
    public Directory getRoot(){
        return root;
    }
    //CREATE DIRECTORY
    public void createDirectory(String path){
        String[] parts=path.split("/");
        Directory current = root;
        for (int i=0; i<parts.length; i++){
            FileSystemNode child=current.getChild(parts[i]);
            if (child == null){
                Directory newDir=new Directory(parts[i]);
                current.addChild(newDir);
                current = newDir;
            }else{
                if(!(child instanceof Directory)){
                    throw new RuntimeException("File exist with path name.");
                }else{
                    current = (Directory) child;
                }
            }
        }
    }
    //CREATE FILE
    public void createFile(String pathAndFileName, long size){
        int indexLastSlash = pathAndFileName.lastIndexOf('/');
        String fileName = pathAndFileName.substring(indexLastSlash+1);
        String dirPath = pathAndFileName.substring(0,indexLastSlash);
        createDirectory(dirPath);

        Directory parent= (Directory) findNode(dirPath);
        parent.addChild(new FileNode(fileName, size));
    }
    //FIND NODE
    public FileSystemNode findNode(String path){
        if(path.isEmpty() || path.equals("/")){
            return root;
        }

        String [] parts= path.split("/");
        FileSystemNode current=root;
        for(int i=0; i<parts.length; i++){
            if(!(current instanceof Directory)){
                return null;
            }
            current = ((Directory) current).getChild(parts[i]);
            if(current == null){
                return null;
            }
        }
        return current;

    }
    //DELETE
    public void delete(String path){
        FileSystemNode  node= findNode(path);
        if(node == null || node == root){
            return;
        }
        node.getParent().removeChild(node);
    }
    //SEARCH
    public List<String> search(String fileName) {
        List<String> result=new ArrayList<>();
        searchDFS(root, "",fileName,result);
        return result;
    }
    private void searchDFS(FileSystemNode node, String currentPath, String target, List<String>result){
        String path= currentPath+"/"+node.getName();
        if(node.getName().equals(target)){
            result.add(path);
        }

        if(node instanceof Directory){
            for (FileSystemNode child:((Directory) node).getChildren()){
                searchDFS(child, path, target, result);
            }
        }
    }

    //MOVE
    public void move(String sourcePath, String destinationPath){
        FileSystemNode  source = findNode(sourcePath);
        Directory destination = (Directory) findNode(destinationPath);
        source.getParent().removeChild(source);
        destination.addChild(source);
    }
    //COPY
    public void copy(String sourcePath, String destinationPath){
        FileSystemNode source= findNode(sourcePath);
        Directory destination=(Directory)findNode(destinationPath);
        destination.addChild(source.deepCopy());
    }
    //PRINT
    public void print(){
        root.print("");
    }
    //SIZE
    public long getSize(String path){
        FileSystemNode node= findNode(path);
        return node.getSize();
    }
    //COUNT FILES
    public int countFiles(String path){
        FileSystemNode node= findNode(path);
        return node.countFiles();
    }

}
