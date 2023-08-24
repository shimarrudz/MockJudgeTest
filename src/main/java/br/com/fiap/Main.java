package br.com.fiap;

import br.com.fiap.domain.entity.Advogado;
import br.com.fiap.domain.entity.Estado;
import br.com.fiap.domain.entity.Processo;
import br.com.fiap.domain.entity.TipoDeAcao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TipoDeAcao tipoAcao = new TipoDeAcao();
        tipoAcao.setNome("Agressão");

        Estado estado = new Estado();
        estado.setNome("Minas Gerais").setSigla("MG");

        Advogado advogado = new Advogado();
        advogado.setNome("Victor Shimada").setNumeroOAB("V15").setEstado(estado);

        Processo processo = new Processo();
        processo.setNumero("1563").setProBono(true).setTipoDeAcao(tipoAcao).setAdvogado(advogado);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();

        List<Processo> processos = manager.createQuery("FROM Processo ").getResultList();
        Processo processoSelecionado = (Processo) JOptionPane.showInputDialog(null, "Selecione um processo", "Seleção de processos", JOptionPane.QUESTION_MESSAGE, null, processos.toArray(), processos.get(0));
        Processo processoById = manager.find(Processo.class, 1L);

        manager.getTransaction().begin();
        manager.persist(processo);
        manager.getTransaction().commit();
        System.out.println(processo);
        System.out.println(processoSelecionado);
        System.out.println(processoById);

        manager.close();
        factory.close();
    }
}