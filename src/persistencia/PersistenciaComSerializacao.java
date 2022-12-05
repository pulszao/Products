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


/**
 Classe que realiza o salvamento e recuperação dos dados do projeto em um arquivo de objeto
 @author Lucas
 */
public class PersistenciaComSerializacao {
    /**
     Método que realiza o salvamento do objeto Loja
     @param loja classe Loja à ser salva
     */
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


    /**
     Método que realiza a recuperação dos dados salvos
     @return retorna a Classe Loja
     */
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
