package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Carrito;
import modelo.Categoria;
import modelo.JuegoMaker;
import servicios.IServiciosTienda;
import servicios.ServiciosTiendaImp;
import utilidades.GestorFicheros;

/**
 * Servlet implementation class TiendaOnline
 */
@WebServlet("/TiendaOnline")
public class TiendaOnline extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// atributos
	IServiciosTienda servicios = new ServiciosTiendaImp();

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("categorias", Categoria.getCategorias());
		String action = request.getParameter("action");

		if (action == null) {
			goHome(request, response);
		} else {
			switch (action) {
			case "show":
				goDetalle(request, response);
				break;

			case "categoria":
				goCategoria(request, response);
				break;

			case "buscarNombre":
				goTitulo(request, response);
				break;
				
			case "top":
				goTop(request, response);
				break;
				
			case "recomendados":
				goRecomendados(request, response);
				break;

			case "addcart":
				if (null != request.getParameter("id"))
					addCart(request,response);
				
				goHome(request, response);
				break;
			case "carrito":
				request.getRequestDispatcher("carrito.jsp").forward(request, response);
				break;
			case "comprado":
				vaciarCarrito(request, response);
				goHome(request, response);
				break;
			default:
				goHome(request, response);
				break;
			}
		}
	}

	private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		Carrito carrito = (Carrito) s.getAttribute("carrito");
		if(null == carrito)
			carrito = new Carrito();
			
		carrito.add(servicios.getJuego(Integer.parseInt(request.getParameter("id"))));
		s.setAttribute("carrito", carrito);
		s.setAttribute("items", carrito.getItemCount());
	}

	private void goHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (servicios.getListaJuegos().isEmpty()) {
			servicios = GestorFicheros.cargarFileToObjet("juegos.dat");
			if (null == servicios) 
				servicios = new ServiciosTiendaImp();
				
			if (servicios.getListaJuegos().isEmpty())
				servicios.setListaJuegos(JuegoMaker.crearPruebas());
		}
		request.setAttribute("juegos", servicios.getListaJuegos());
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	private void goDetalle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("juego", servicios.getJuego(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("detalle.jsp").forward(request, response);
		} catch (Exception e) {
			goError(request, response, "id introducido es incorrecto");
		}

	}

	private void goCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", new StringBuilder("Juegos de ").append(Categoria.getFromIndex(Integer.parseInt(request.getParameter("id")))).append(":"));
		request.setAttribute("juegos", servicios.buscarJuegosCategoria(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	private void goTitulo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title",
				new StringBuilder("Resultados de la búsqueda \"").append(request.getParameter("nombre")).append("\":"));
		request.setAttribute("juegos", servicios.buscarJuegosTitulo(request.getParameter("nombre")));
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	private void goTop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", new StringBuilder("Top ventas:"));
		request.setAttribute("juegos", servicios.listaTop());
		request.setAttribute("isOrdenada", true);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	private void goRecomendados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", new StringBuilder("Lista de nuestras recomendaciones:"));
		request.setAttribute("juegos", servicios.listaRecomendado());
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	private void vaciarCarrito(HttpServletRequest request, HttpServletResponse response){
		HttpSession s = request.getSession();
		Carrito carrito = (Carrito) s.getAttribute("carrito");
		carrito.getItems().clear();
		s.setAttribute("carrito",carrito);
		s.setAttribute("items",carrito.getItemCount());
	}

	private void goError(HttpServletRequest request, HttpServletResponse response, String msgError)
			throws ServletException, IOException {
		request.setAttribute("msgError", new StringBuilder("<strong>ERROR</strong>: ").append(msgError).append("."));
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
