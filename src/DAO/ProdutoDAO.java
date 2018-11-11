package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author priscyla.poliveira
 */
public class ProdutoDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String url = "";
    private static Connection conexao;
    
    public static boolean Salvar(Produto p){
        boolean retorno = false;
        
        try {
            //Simulo uma inserção no banco de dados (INSERT INTO...)
            //return SimulaDB.getInstance().SalvarCliente(p);
            Class.forName(DRIVER);
            url="jdbc:mysql://localhost:3306/lojacarro";
            conexao = DriverManager.getConnection(url,"root","");
            Statement comando = conexao.createStatement();
            int linhasAfetadas = comando.executeUpdate("INSERT INTO carro (ano, valor, modelo) " + 
                    "VALUES(" + p.getAno() + "," + p.getValor() + "," + "'" + p.getModelo() + "'" + ")");
            
            retorno = linhasAfetadas>0;
            
        } catch (ClassNotFoundException | SQLException ex) {
            retorno = false;
        }finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
            
        }
        
        return retorno;
        
              
    }
    
    public static boolean Atualizar(Produto p){
        //Simulo um  UPDATE no banco de dados (UPDATE TabelaXYZ SET...)
        //return SimulaDB.getInstance().AtualizarCliente(p);
        
        boolean retorno = false;
        
        try {
            //Simulo uma inserção no banco de dados (INSERT INTO...)
            Class.forName(DRIVER);
            url="jdbc:mysql://localhost:3306/" + "lojacarro";
            conexao = DriverManager.getConnection(url,"root","");
            
            Statement comando = conexao.createStatement();
            int linhasAfetadas = comando.executeUpdate("UPDATE carro SET " + 
                    " ano =" + p.getAno() + "," + " valor =" + p.getValor() + "," + " modelo =" + "'" + p.getModelo() + "'"
                    + " WHERE idcarro =" + p.getId());
            
            retorno = linhasAfetadas>0;
            
        } catch (ClassNotFoundException | SQLException ex) {
            retorno = false;
        }finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
            
        }
        
        return retorno; 
    }
    
    public static boolean Excluir(int pID){
        //Simulo uma exclusão no banco de dados (DELETE FROM TabelaXYZ WHERE...)
        boolean retorno = false;
        
        try {
            //Simulo uma inserção no banco de dados (INSERT INTO...)
            Class.forName(DRIVER);
            url="jdbc:mysql://localhost:3306/lojacarro";
            conexao = DriverManager.getConnection(url,"root","");
            
            Statement comando = conexao.createStatement();
            //PreparedStatement comando = conexao.prepareStatement("DELETE FROM carro WHERE idcarro=?");
            
            int linhasAfetadas = comando.executeUpdate("DELETE FROM carro " + " WHERE idcarro =" + pID);
            
            retorno = linhasAfetadas>0;
            
        } catch (ClassNotFoundException | SQLException ex) {
            retorno = false;
        }finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
            
        }
        
        return retorno;               
    }
    
    public static ArrayList<Produto> getProduto(){
        ArrayList<Produto> listaClientes = new ArrayList<>();
        
        try {
            //return SimulaDB.getInstance().getClientes();
            Class.forName(DRIVER);
            url = "jdbc:mysql://" + "localhost:3306/lojacarro";
            conexao = DriverManager.getConnection(url,"root","");
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM carro;");
            while(rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("idcarro"));
                p.setAno(rs.getInt("ano"));
                p.setValor(rs.getDouble("valor"));
                p.setModelo(rs.getString("modelo"));
                listaClientes.add(p);
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            listaClientes = null;
        } finally{
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaClientes = null;
            }
        }
        
        return listaClientes;
    }
}
