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
            FileOutputStream fs = new FileOutputStream("produtos.obj");
            ObjectOutputStream escreve = new ObjectOutputStream(fs);
            escreve.writeObject(loja);
            escreve.flush();
            escreve.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro de IO");
        }

    }


    public Loja recuperarLoja() {
        Loja tempLoja = new Loja(30);

        try {
            FileInputStream fs = new FileInputStream("produtos.obj");
            ObjectInputStream leitor = new ObjectInputStream(fs);
            tempLoja = (Loja) leitor.readObject();
            leitor.close();
        } catch (IOException e) {
            System.out.println("Erro de IO");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de Classe");
        }

        return tempLoja;
    }
}
