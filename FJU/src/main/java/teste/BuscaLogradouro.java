package teste;

/*
 * BuscaLogradouro.java
 *
 * Criado em 4 de Junho de 2007, 10:27 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Fabio Souza
 */
public class BuscaLogradouro {
    
    public static void main(String[] args) {
        new BuscaLogradouro();
    }
    
    public BuscaLogradouro() {
        try {
            String cep = "89015250";
            

            CepWebService cepWebService = new CepWebService(cep);
                
            if (cepWebService.getResultado()==1) {
                String endereco = cepWebService.getTipo_logradouro() + " " + cepWebService.getLogradouro();
                String siglaEstado = cepWebService.getEstado();
                String nomeCidade = cepWebService.getCidade();
                String nomeBairro = cepWebService.getBairro();
                int resultado = cepWebService.getResultado();
                
            }
            else {
                System.out.println("Servidor não está respondendo.");
            }            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }  
    }    
}
