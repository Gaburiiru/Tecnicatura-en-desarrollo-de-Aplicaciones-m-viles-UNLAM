package unlam.ej3;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, res;
		float a1, b1, res1;
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("ARITMETICOS - BINARIOS");
		System.out.println("-----------------------------------------------------------------------------------------"); 
		
		a=1;
		b=2;
		res = a + b;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando hago 'a + b' obtengo " + res); 
		
		a=3;
		b=2;
		res = a - b;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando hago 'a - b' obtengo " + res); 
		
		a=3;
		b=2;
		res = a * b;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando hago 'a * b' obtengo " + res); 
		
		a=3;
		b=2;
		res = a / b;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando hago 'a / b' obtengo " + res); 
		
		a1=(float) 3.5;
		b=2;
		res1 = a1 / b;
		System.out.println("Si 'a' vale " + a1 + " y 'b' vale " + b + " cuando hago 'a / b' obtengo " + res1);
		
		a1=(float) 3.5;
		b1=(float) 2.0;
		res1 = a1 / b1;
		System.out.println("Si 'a' vale " + a1 + " y 'b' vale " + b1 + " cuando hago 'a / b' obtengo " + res1);
		
		a1=(float) 3.5;
		b1=(float) 2.0;
		res1 = a1 % b1;
		System.out.println("Si 'a' vale " + a1 + " y 'b' vale " + b1 + " cuando hago 'a % b' obtengo " + res1);
		
		a=3;
		b=2;
		res1 = a % b;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando hago 'a % b' obtengo " + res + " (si asigno a una variable entera)");
		
		a=3;
		b=2;
		res1 = a % b;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando hago 'a % b' obtengo " + res1 + " (si asigno a una variable float)");
		
		a1=3;
		b1=2;
		res1 = a1 % b1;
		System.out.println("Si 'a' vale " + a1 + " y 'b' vale " + b1 + " cuando hago 'a % b' obtengo " + res1);

		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("ARITMETICOS - UNARIOS");
		System.out.println("-----------------------------------------------------------------------------------------"); 
		
		a=3;
		res = -a;
		System.out.println("Si 'a' vale " + a + " cuando hago '-a' obtengo " + res);
		
	
		a=3;
		System.out.println("Si 'a' vale " + a + " cuando hago '--a' obtengo " + --a + " si luego consulto 'a' vale " + a);
		
		a=3;
		System.out.println("Si 'a' vale " + a + " cuando hago 'a--' obtengo " + a-- + " si luego consulto 'a' vale " + a);
		
		a=3;
		System.out.println("Si 'a' vale " + a + " cuando hago '++a' obtengo " + ++a + " si luego consulto 'a' vale " + a);
		
		a=3;
		System.out.println("Si 'a' vale " + a + " cuando hago 'a++' obtengo " + a++ + " si luego consulto 'a' vale " + a);
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("ARITMETICOS - ASIGNACION");
		System.out.println("-----------------------------------------------------------------------------------------"); 

		a=3;
		res = a;
		System.out.println("Si 'a' vale " + a + " y 'res' vale cualquier cosa, cuando hago 'res = a' obtengo que 'res' vale " + res);
		
		a=3;
		res = 1;
		res += a;
		System.out.println("Si 'a' vale " + a + " y 'res' vale " + 1 + " cuando hago 'res += a' obtengo que 'res' vale " + res + " por que equivale a 'res = res + a'");

		a=3;
		res = 4;
		res -= a;
		System.out.println("Si 'a' vale " + a + " y 'res' vale " + 4 + " cuando hago 'res -= a' obtengo que 'res' vale " + res + " por que equivale a 'res = res - a'");
		
		a=3;
		res = 8;
		res *= a;
		System.out.println("Si 'a' vale " + a + " y 'res' vale " + 8 + " cuando hago 'res *= a' obtengo que 'res' vale " + res + " por que equivale a 'res = res * a'");
		
		a=2;
		res = 4;
		res /= a;
		System.out.println("Si 'a' vale " + a + " y 'res' vale " + 4 + " cuando hago 'res /= a' obtengo que 'res' vale " + res + " por que equivale a 'res = res / a'");
	
		a=4;
		res = 2;
		res %= a;
		System.out.println("Si 'a' vale " + a + " y 'res' vale " + 2 + " cuando hago 'res %= a' obtengo que 'res' vale " + res + " por que equivale a 'res = res % a'");
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("RELACIONALES - COMPARACION");
		System.out.println("-----------------------------------------------------------------------------------------"); 
		
		a=4;
		b=4;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a==b' obtengo " + (a==b));
		
		a=4;
		b=5;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a==b' obtengo " + (a==b));
		
		a=4;
		b=4;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a!=b' obtengo " + (a!=b));
		
		a=4;
		b=5;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a!=b' obtengo " + (a!=b));
		
		a=4;
		b=4;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a>b' obtengo " + (a>b));
		
		a=4;
		b=5;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a>b' obtengo " + (a>b));
		
		a=4;
		b=4;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a>=b' obtengo " + (a>=b));
		
		a=4;
		b=5;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a>=b' obtengo " + (a>=b));
		
		a=4;
		b=4;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a<b' obtengo " + (a<b));
		
		a=4;
		b=5;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a<b' obtengo " + (a<b));
		
		a=4;
		b=4;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a<=b' obtengo " + (a<=b));
		
		a=4;
		b=5;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando consulto 'a<=b' obtengo " + (a<=b));
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("RELACIONALES - CONDICIONAL");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		a=4;
		b=5;
		res=a<=b?a:b;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando ejecuto 'res=a<=b?a:b' obtengo " + res);
		
		a=5;
		b=4;
		res=a<=b?a:b;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando ejecuto 'res=a<=b?a:b' obtengo " + res);
		
		a=5;
		b=5;
		res=a<=b?a:b;
		System.out.println("Si 'a' vale " + a + " y 'b' vale " + b + " cuando ejecuto 'res=a<=b?a:b' obtengo " + res);
		
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("RELACIONALES - BOOLEANOS");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		a=5;
		b=5;
		res=8;
		System.out.println("Si 'a' vale " + a + ", 'b' vale " + b + "y 'res' vale " + res + " cuando consulto '(a<b)&&res==8' obtengo " + ((a<b)&&res==8));
		
		a=4;
		b=5;
		res=8;
		System.out.println("Si 'a' vale " + a + ", 'b' vale " + b + "y 'res' vale " + res + " cuando consulto '(a<b)&&res==8' obtengo " + ((a<b)&&res==8));

		a=5;
		b=5;
		res=8;
		System.out.println("Si 'a' vale " + a + ", 'b' vale " + b + "y 'res' vale " + res + " cuando consulto '(a<b)||res==8' obtengo " + ((a<b)||res==8));
		
		a=4;
		b=5;
		res=8;
		System.out.println("Si 'a' vale " + a + ", 'b' vale " + b + "y 'res' vale " + res + " cuando consulto '(a<b)||res==8' obtengo " + ((a<b)||res==8));
		
		a=4;
		b=5;
		System.out.println("Si 'a' vale " + a + ", 'b' vale " + b + " cuando consulto '!(a<b)' obtengo " + (!(a<b)));
		
		a=5;
		b=4;
		System.out.println("Si 'a' vale " + a + ", 'b' vale " + b + " cuando consulto '!(a<b)' obtengo " + (!(a<b)));
	}
}
