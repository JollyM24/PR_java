package task21_22;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main21_3 {
    public static void main(String[] args) {
        Frame frame = new Frame();
    }

    public static class TextDocument implements IDocument {
        FileWriter fw;

        @Override
        public void save() {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void create() {
            try {
                fw = new FileWriter("sample1.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void open() {
            try {
                fw = new FileWriter("sample1.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void close() {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Frame {
        IDocument doc;
        ICreateDocument doc1;

        private int getInput() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите тип документа");
            System.out.println("1.Текстовый документ");
            return scanner.nextInt();
        }

        private void New() {
            int i = getInput();
            if (i == 1)
                NewText();
            System.out.println("Документ создан");
        }

        private void Open() {
            int i = getInput();
            if (i == 1)
                OpenText();
            System.out.println("Документ открыт");

        }

        private void Exit() {
            int i = getInput();
            if (i == 1)
                ExitText();
            System.out.println("Прекращение работы");
        }

        private void Save() {
            int i = getInput();
            if (i == 1)
                SaveText();
            System.out.println("Документ сохранен");
        }

        private void NewText() {
            doc1 = new CreateTextDocument();
            doc = doc1.CreateNew();
            doc.create();
        }

        private void OpenText() {
            doc1 = new CreateTextDocument();
            doc = doc1.CreateOpen();
            doc.open();
        }

        private void ExitText() {
            if (doc != null)
                doc.close();
        }

        private void SaveText() {
            if (doc != null)
                doc.save();
        }

        public Frame() {
            boolean go = true;
            while (go) {
                System.out.println("Выберите пункт меню");
                System.out.println("1.New");
                System.out.println("2.Open");
                System.out.println("3.Save");
                System.out.println("4.Exit");
                Scanner scanner = new Scanner(System.in);
                int i = scanner.nextInt();
                if (i == 4) {
                    Exit();
                    go = false;
                } else if (i == 1)
                    New();
                else if (i == 2)
                    Open();
                else if (i == 3)
                    Save();
            }
        }
    }

    public interface IDocument {

        void save();

        void create();

        void open();

        void close();
    }

    public abstract static class ICreateDocument {
        abstract IDocument CreateNew();

        abstract IDocument CreateOpen();
    }

    public static class CreateTextDocument extends ICreateDocument {
        @Override
        IDocument CreateNew() {
            return new TextDocument();
        }

        @Override
        IDocument CreateOpen() {
            return new TextDocument();
        }
    }
}