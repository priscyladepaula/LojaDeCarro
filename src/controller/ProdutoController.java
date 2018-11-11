package controller;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author priscyla.poliveira
 */
public class ProdutoController {
    
    public static boolean Salvar(int ano, double valor, String modelo){
        //Salvo na memória
        Produto p =  new Produto(ano, valor, modelo);
        return ProdutoDAO.Salvar(p);
    }
    
    public static boolean Excluir(int pID){
        return ProdutoDAO.Excluir(pID);
    }
    
    public static boolean Atualizar(int id, int ano, double valor, String modelo){
        Produto p =  new Produto(id, ano, valor, modelo);
        return ProdutoDAO.Atualizar(p);
        
    }
    
    /**
     * Transformo uma lista de objetos Produto em uma lista de Strings
     * @return lista de string
     */
    public static ArrayList<String[]> getProdutos(){
        ArrayList<Produto> produtos = ProdutoDAO.getProduto();
        ArrayList<String[]> listaProdutos = new ArrayList<>();
        
        for(int i=0; i < produtos.size(); i++){
            listaProdutos.add(new String[]{String.valueOf(produtos.get(i).getId())
                                    , String.valueOf(produtos.get(i).getAno())
                                    ,  String.valueOf(produtos.get(i).getValor())
                                    , produtos.get(i).getModelo()});
        }
        
        return listaProdutos;
        
    }
}
