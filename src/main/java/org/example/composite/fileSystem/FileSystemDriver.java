package org.example.composite.fileSystem;

public class FileSystemDriver {
    public static void main(String[] args) {
        FileSystemService fs=new FileSystemService();
        fs.createDirectory("documents");
        fs.createDirectory("photos");
        fs.createDirectory("documents/imp");
        fs.createFile("documents/resume.pdf", 200);
        fs.createFile("documents/notes.txt", 100);
        fs.createFile("documents/imp/notes.txt", 50);


        fs.createDirectory("photos/vacation");
        fs.createDirectory("photos/imp");
        fs.createFile("photos/vacation/img1.jpeg",50);
        fs.createFile("photos/vacation/img2.jpeg",30);
        fs.createFile("photos/imp/notes.jpeg",10);

        fs.print();

        System.out.println("Size of /documents : "+fs.getSize("documents"));
        System.out.println("Count files of /photos : "+fs.countFiles("photos"));
        System.out.println("Search notes : "+fs.search("notes.txt"));
        fs.move("documents/resume.pdf", "photos");
        fs.copy("photos/vacation", "documents");
        fs.print();

    }
}
