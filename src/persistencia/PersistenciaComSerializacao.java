//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package persistencia;

import model.Loja;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistenciaComSerializacao {

    public void salvarLoja(Loja loja) {
        try {
            FileOutputStream fs = new FileOutputStream("loja.obj");
            ObjectOutputStream escreve = new ObjectOutputStream(fs);
            escreve.writeObject(loja);
            escreve.flush();
            escreve.close();
        } catch (IOException var4) {
            System.out.println("Erro de IO");
        }

    }

    public Loja recuperarAcervo() {
        Loja tempLoja = new Loja(100);

        try {
            FileInputStream fs = new FileInputStream("loja.obj");
            ObjectInputStream leitor = new ObjectInputStream(fs);
            tempLoja = (Loja)leitor.readObject();
            leitor.close();
        } catch (IOException var4) {
            System.out.println("Erro de IO");
        } catch (ClassNotFoundException var5) {
            System.out.println("Erro de Classe");
        }

        return tempLoja;
    }
}
