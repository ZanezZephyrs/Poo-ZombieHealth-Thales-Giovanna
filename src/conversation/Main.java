package conversation;
import datasource.*;
import conversation.*;
import interfaces.*;

public class Main {

	public static void main(String[] args) {
		
		DataSetComponent reader=new DataSetComponent();
		reader.setDataSource("..\\Data\\dados.csv");
		System.out.println(reader.requestAttributes().toString());

	}

}
