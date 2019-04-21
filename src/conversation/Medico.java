package conversation;
import interfaces.*;
import java.util.ArrayList;

public class Medico implements IResponderReceptacle, IEnquirer {
		private IResponder paciente_em_atendimento;
	 	private String[] respostas;
	    private ArrayList<String> diagnostic;
	    public Medico() {
	        this.respostas=new String[7];
	        this.diagnostic=new ArrayList<String>();
	        this.paciente_em_atendimento=null;
	    }
	    
		public void connect(IResponder responder) {
			this.paciente_em_atendimento=responder;
			
		}
	    
	    public void Mostra_diagnostico() {
	        System.out.println("possiveis diagnosticos:");
	        for(int i=0;i<this.diagnostic.size();i++) {
	            System.out.println(this.diagnostic.get(i));
	        }
	    }
	    
	    public void Diagnosticar(String [][] mat) {
	        for(int i=0;i<mat.length;i++) {
	            for(int j=0;j<mat[i].length-1;j++) {       
	                if(mat[i][j].equalsIgnoreCase(this.respostas[j])==false) {
	                    break;
	                }if(j==mat[i].length-2 ) {
	                    this.diagnostic.add(mat[i][j+1]);
	                }
	            }
	        }
	        Mostra_diagnostico();
	    }
	
	
	public void startInterview() {
		if(this.paciente_em_atendimento==null) {
			System.out.println("Nenhum paciente em atendimento");
			return;
		}
		
		this.respostas[0]=this.paciente_em_atendimento.ask("tem paralisia?");
        this.respostas[1]=this.paciente_em_atendimento.ask("tem lingua amarela?");
        this.respostas[2]=this.paciente_em_atendimento.ask("tem todos os menbro?");
        this.respostas[3]=this.paciente_em_atendimento.ask("tem dor no peito?");
        this.respostas[4]=this.paciente_em_atendimento.ask("tem dedos tremulos?");
        this.respostas[5]=this.paciente_em_atendimento.ask("tem raiva?");
        this.respostas[6]=this.paciente_em_atendimento.ask("tem historico?");
        
        this.paciente_em_atendimento.finalAnswer("algo");
		
	}



}
