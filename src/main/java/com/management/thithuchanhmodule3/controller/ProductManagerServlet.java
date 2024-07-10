package com.management.thithuchanhmodule3.controller;

import com.management.thithuchanhmodule3.model.Product;
import com.management.thithuchanhmodule3.model.ProductDTO;
import com.management.thithuchanhmodule3.service.IProductService;
import com.management.thithuchanhmodule3.service.iml.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductManagerServlet", value = "/managerproduct")
public class ProductManagerServlet extends HttpServlet {

    IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                listCompany(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(request, response);
                break;
            case "search":
                listProductChoice(request, response);
                break;

        }
    }


    private void listCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDTO> listProduct = productService.listProduct();
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/view.jsp");
        dispatcher.forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Product product = new Product(name, price, discount, stock);
        productService.addProduct(product);
        response.sendRedirect("/managerproduct");
    }

    private void listProductChoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("choice");
        List<ProductDTO> listProduct = productService.listProductchoice(choice);
        request.setAttribute("listProduct", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/view.jsp");
        dispatcher.forward(request, response);
    }
}
