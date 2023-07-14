package entity;

public class RunTest {

	public static void main(String[] args) {
		Chapa chapaTest = new Chapa(1200.0,3000.0,1.5,Material.CARBONO);
		Item itemTest = new Item (1.0, chapaTest);
		Grupo grupoTest = new Grupo (itemTest);
		grupoTest.addItem(itemTest);
		
		
		print("Peso do grupo:" + String.valueOf(grupoTest.getPesoTotal()));
		print("Peso do item:" + String.valueOf(itemTest.getPeso()));
		print("Peso da chapa:" + String.valueOf(chapaTest.getPesoKg()));
		
		// LOOP
		int repeat = 50; 
		for (int i = 0 ; i < repeat ; i++) {
			Item it = new Item (1.0, chapaTest);
			grupoTest.addItem(it);
		}
		print("Peso do grupo depois do loop:" + String.valueOf(grupoTest.getPesoTotal()));
		
		
	}
	
	public static void print(String a) {
		System.out.println(a);
	}

}
