import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDatos {
	//DATOS
	private Connection cn;
	private String driver="com.mysql.jdbc.Driver";
	private String cadenaConexion="jdbc:mysql://localhost:3306/gestioncorreo";

	public BaseDatos() {
		try {
			cn=DriverManager.getConnection(cadenaConexion, "root" ,"");
		}catch (SQLException e) {
			e.printStackTrace();
			cn=null;
		}
	}

	public int guardarMail(String asunto, String texto) {
		String sent;
		//PREPARAR LA SENTENCIA 
		sent = "INSERT INTO mails (asunto,texto) VALUES (?,?)";
		PreparedStatement sentencia;
		ResultSet rs;

		try {
			sentencia=cn.prepareStatement(sent);
			sentencia.setString(1, asunto); //el numero es el ? que es 
			sentencia.setString(2, texto);	//el numero es el ? que es 
			int cont= sentencia.executeUpdate(); 
			
			
			sent="SELECT MAX(idMail) FROM mails"; //para obtener el id del mail enviado
			sentencia=cn.prepareStatement(sent, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // no se muy bien que hacen los resultset del parentesis
			rs=sentencia.executeQuery();  
			rs.first();
			return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int guardarEnvios(int idMail, String strMails) {
		String [] mails;
		mails=strMails.split(", "); //nueva funcion split, divide en array que se va dimensionando los string en base a algo que separa, como / o ,
		String sent;
		PreparedStatement sentencia;
		ResultSet rs;
		int idPersona,cont;

		cont=0;

		for (String mail : mails) {
			//BUSCAr EL ID CORRESPONDIENTE A ESTE MAIL 
			sent="SELECT id FROM personas WHERE correo=?";

			try {
				sentencia=cn.prepareStatement(sent,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				sentencia.setString(1, mail);
				rs=sentencia.executeQuery();
				rs.first();
				idPersona=rs.getInt(1);
				
				sent="INSERT INTO enviados VALUES (null,?,?)";
				sentencia=cn.prepareStatement(sent);
				sentencia.setInt(1,idMail);
				sentencia.setInt(2, idPersona);
				sentencia.executeUpdate();
				cont++;
			}catch (SQLException e) {
				e.printStackTrace();
			}		
		}

		return cont;
	}

	//ACCIONES SOBRE LA BASE DE DATOS
	public int insertar(Persona per) {
		//ESCRIBIR LA SENTENCIA 

		//PREPARARLA 

		//LANZARLA
		String strSent;
		PreparedStatement sentencia;
		Empleado emp;
		strSent= "INSERT INTO personas VALUES (null,?,?,?,?,?,?,?)";
		//ASIGNAR LOS VALORES A LOS PARAMETROS (?) LOS DE EOMPEADO VACIOS



		try {
			sentencia = cn.prepareStatement(strSent);
			sentencia.setString(1, per.getNombre());
			sentencia.setString(2, per.getCorreo());
			sentencia.setString(3, per.getWeb());
			sentencia.setBoolean(4, false);
			sentencia.setInt(5, -1);
			sentencia.setString(6, "");
			sentencia.setString(7, "");



			if(per.getClass()==Empleado.class) {
				//ASIGNAR LOS VALORES DE LOS PARAMETROS QUE SOLO SON DE EMPLEADO(esEmpleado a true)
				emp=(Empleado) per;
				sentencia.setBoolean(4, true);
				sentencia.setInt(5, emp.getEdad());
				sentencia.setString(6, emp.getDireccion());
				sentencia.setString(7, emp.getTelefono());

			}		

			return sentencia.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();

		}
		return 0;
	}



	public Connection getCn() {
		return cn;
	}

	public void setCn(Connection cn) {
		this.cn = cn;
	}


	public ResultSet ObtenerTodos() {
		String sentencia;
		PreparedStatement sqlSent;
		ResultSet rs;
		sentencia = "SELECT * FROM personas";

		try {
			sqlSent = cn.prepareStatement(sentencia, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = sqlSent.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}


}
