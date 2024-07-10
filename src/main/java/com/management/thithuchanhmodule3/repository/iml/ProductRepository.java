package com.management.thithuchanhmodule3.repository.iml;

import com.management.thithuchanhmodule3.model.Product;
import com.management.thithuchanhmodule3.model.ProductDTO;
import com.management.thithuchanhmodule3.repository.IProductRepository;
import com.management.thithuchanhmodule3.repository.connecdatabase.ConnecDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private static final String SELECT_ALL = "call codegym.getListItem();";
    private static final String INSERT_PRODUCT = "INSERT INTO product_manager (product_name, price, discount_id, inventory)  VALUES (?,?,?,?)";
    private static final String SELECT_PRODUCT = "call codegym.getListIProduct(?);";
    @Override
    public List<ProductDTO> listProduct() {
        List<ProductDTO> listProduct = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnecDatabase.getConnection().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            String name;
            int price;
            String discount;
            int stock;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                price = resultSet.getInt("price");
                discount = resultSet.getString("discount");
                stock = resultSet.getInt("stock");
                listProduct.add(new ProductDTO(name, price, discount, stock));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listProduct;
    }

    @Override
    public void addProduct(Product product) {
        try (PreparedStatement preparedStatement = ConnecDatabase.getConnection().prepareStatement(INSERT_PRODUCT)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getProductPrice());
            preparedStatement.setInt(3, product.getDiscount());
            preparedStatement.setInt(4, product.getInventory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductDTO> listProductChoice(String choice) {
        List<ProductDTO> listProduct = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnecDatabase.getConnection().prepareStatement(SELECT_PRODUCT)) {
            preparedStatement.setString(1, choice);
            ResultSet resultSet = preparedStatement.executeQuery();
            String name;
            int price;
            String discount;
            int stock;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                price = resultSet.getInt("price");
                discount = resultSet.getString("discount");
                stock = resultSet.getInt("stock");
                listProduct.add(new ProductDTO(name, price, discount, stock));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listProduct;
    }
}
