/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


/**
 *
 * @author ACER
 */

public class QuanLyKhoView extends JFrame {
    JLabel lbHoTen, dataHoTen, lbID, dataID, lbLoai, dataLoai;
    public QuanLyKhoView(){
        initComponents();
    }
    
    public void initComponents(){
        JFrame f = new JFrame("Admin");
        f.setSize(1400, 850);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        //######################################################################
        // PANEL THANH DIEU HUONG
        JPanel thanhDieuHuong = new JPanel(new BorderLayout());
        thanhDieuHuong.setBackground(Color.red);
                
        //Tạo panelThongTinUser
        JPanel panelThongTinUser = new JPanel(new GridBagLayout());
        panelThongTinUser.setBackground(Color.decode("#56c2f5"));
        panelThongTinUser.setPreferredSize(new Dimension(200,100));
        //Tạo các label Họ tên, ID, Vị trí của nhân viên
        //Những label hoTen, ID, viTri sẽ được lấy sau từ phương thức get 
        
        
        lbHoTen = new JLabel("Name: ");
        dataHoTen = new JLabel();
        
        lbID = new JLabel("ID: ");
        dataID = new JLabel();
        
        lbLoai = new JLabel("Role: ");
        dataLoai = new JLabel();
        
        //Set mau cho chu
        lbHoTen.setForeground(Color.white);
        dataHoTen.setForeground(Color.white);
        lbID.setForeground(Color.white);
        dataID.setForeground(Color.white);
        lbLoai.setForeground(Color.white);
        dataLoai.setForeground(Color.white);
        
        //Set co chu cho labels
        Font labelFont = new Font("Arial", Font.BOLD, 15);
        lbHoTen.setFont(labelFont);
        dataHoTen.setFont(labelFont);
        lbID.setFont(labelFont);
        dataID.setFont(labelFont);
        lbLoai.setFont(labelFont);
        dataLoai.setFont(labelFont);
        
        
        // Tạo một đối tượng GridBagConstraints để kiểm soát vị trí và kích thước của các thành phần trong panelthongTinUser.
        GridBagConstraints gbc = new GridBagConstraints();
        // Xác định vị trí của hoTenLabel trong thongTinUser (cột 0, hàng 0).
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Căn chữ bên trái
        panelThongTinUser.add(lbHoTen, gbc);
        // Xác định vị trí của hoTen trong thongTinUser (cột 1, hàng 0).
        gbc.gridx = 1;
        panelThongTinUser.add(dataHoTen, gbc);
        // Xác định vị trí của IDLabel trong thongTinUser (cột 0, hàng 1).
        gbc.gridx = 0; gbc.gridy = 1;
        panelThongTinUser.add(lbID, gbc);
        // Xác định vị trí của ID trong thongTinUser (cột 1, hàng 1).
        gbc.gridx = 1;
        panelThongTinUser.add(dataID, gbc);
        //Xác định vị trí của viTriLabel trong thongTinUser (cột 0, hàng 2).
        gbc.gridx = 0; gbc.gridy = 2;
        panelThongTinUser.add(lbLoai, gbc);
        //xác định vị trí của viTri trong thongTinUser (cột 1, hàng 2).
        gbc.gridx = 1;
        panelThongTinUser.add(dataLoai, gbc);
        thanhDieuHuong.add(panelThongTinUser, BorderLayout.NORTH);
        
        //Lấy data từ database để set cho dataHoTen, dataID, dataLoai
        
        
        //Tạo mainPanel dùng GridBagLayout để chỉnh được cách bố trí các thành phần nút chuyển hướng
        JPanel panelCenter = new JPanel(new GridLayout(11,1));
        panelCenter.setBackground(Color.decode("#56c2f5"));

        //CÁC NÚT CHỨC NĂNG
        //NÚT SẢN PHẨM
        JButton buttonSanPham = new JButton();
        buttonSanPham.setLayout(null);
        buttonSanPham.setBackground(Color.decode("#56c2f5"));
        buttonSanPham.setBorderPainted(false);         // Ẩn viền của buttonSanPham
        ImageIcon iconSanPham = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\box.png");
        Image imgSanPham = iconSanPham.getImage().getScaledInstance(40, 40,java.awt.Image.SCALE_SMOOTH);
        iconSanPham = new ImageIcon(imgSanPham);
        
        JLabel lbSanPham = new JLabel("PRODUCTS", JLabel.CENTER);
        lbSanPham.setVerticalAlignment(JLabel.CENTER);
        lbSanPham.setForeground(Color.WHITE);
        JPanel panelSanPham = new JPanel();
        panelSanPham.setLayout(new GridBagLayout());
        panelSanPham.setBackground(Color.decode("#56c2f5"));
        panelSanPham.setBounds(0,0,250,60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelSanPham.add(new JLabel(iconSanPham), gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbSanPham.setHorizontalAlignment(SwingConstants.LEFT);  // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelSanPham.add(lbSanPham, gbc);
        buttonSanPham.add(panelSanPham);
        
        buttonSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                panelSanPham.setBackground(Color.decode("#357ded"));
                buttonSanPham.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                panelSanPham.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonSanPham);

        //NÚT NHÀ CUNG CẤP
        JButton buttonNhaCungCap = new JButton();
        buttonNhaCungCap.setLayout(null);
        buttonNhaCungCap.setBackground(Color.decode("#56c2f5"));
        buttonNhaCungCap.setBorderPainted(false);         // Ẩn viền của buttonNhaCungCap
        ImageIcon iconNhaCungCap = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\office-building.png");
        Image imgNhaCungCap = iconNhaCungCap.getImage().getScaledInstance(35, 35,java.awt.Image.SCALE_SMOOTH);
        iconSanPham = new ImageIcon(imgNhaCungCap);
        
        JLabel lbNhaCungCap = new JLabel("SUPPLIER", JLabel.CENTER);
        lbNhaCungCap.setVerticalAlignment(JLabel.CENTER);
        lbNhaCungCap.setForeground(Color.WHITE);
        JPanel panelNhaCungCap = new JPanel();
        panelNhaCungCap.setLayout(new GridBagLayout());
        panelNhaCungCap.setBackground(Color.decode("#56c2f5"));
        panelNhaCungCap.setBounds(0,0,250,60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelNhaCungCap.add(new JLabel(iconSanPham), gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);  // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelNhaCungCap.add(lbNhaCungCap, gbc);
        buttonNhaCungCap.add(panelNhaCungCap);
        buttonNhaCungCap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                panelNhaCungCap.setBackground(Color.decode("#357ded"));
                panelNhaCungCap.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                panelNhaCungCap.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonNhaCungCap);
        
        //NÚT NHẬP HÀNG
        JButton buttonNhapHang = new JButton();
        buttonNhapHang.setLayout(null);
        buttonNhapHang.setBackground(Color.decode("#56c2f5"));
        buttonNhapHang.setBorderPainted(false);         // Ẩn viền của buttonNhapHang
        ImageIcon iconNhapHang = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\import.png");
        Image imgNhapHang = iconNhapHang.getImage().getScaledInstance(35, 35,java.awt.Image.SCALE_SMOOTH);
        iconNhapHang = new ImageIcon(imgNhapHang);
        
        JLabel lbNhapHang = new JLabel("IMPORT", JLabel.CENTER);
        lbNhapHang.setVerticalAlignment(JLabel.CENTER);
        lbNhapHang.setForeground(Color.WHITE);
        JPanel panelNhapHang = new JPanel();
        panelNhapHang.setLayout(new GridBagLayout());
        panelNhapHang.setBackground(Color.decode("#56c2f5"));
        panelNhapHang.setBounds(0,0,250,60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelNhapHang.add(new JLabel(iconNhapHang), gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbNhapHang.setHorizontalAlignment(SwingConstants.LEFT);  // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelNhapHang.add(lbNhapHang, gbc);
        buttonNhapHang.add(panelNhapHang);
        buttonNhapHang.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                panelNhapHang.setBackground(Color.decode("#357ded"));
                panelNhapHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                panelNhapHang.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonNhapHang);
        
        //NÚT PHIẾU NHẬP
        JButton buttonPhieuNhap = new JButton();
        buttonPhieuNhap.setLayout(null);
        buttonPhieuNhap.setBackground(Color.decode("#56c2f5"));
        buttonPhieuNhap.setBorderPainted(false);         // Ẩn viền của buttonNhapHang
        ImageIcon iconPhieuNhap = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\documents.png");
        Image imgPhieuNhap = iconPhieuNhap.getImage().getScaledInstance(35, 35,java.awt.Image.SCALE_SMOOTH);
        iconPhieuNhap = new ImageIcon(imgPhieuNhap);
        
        JLabel lbPhieuNhap = new JLabel("RECEIPT", JLabel.CENTER);
        lbPhieuNhap.setVerticalAlignment(JLabel.CENTER);
        lbPhieuNhap.setForeground(Color.WHITE);
        JPanel panelPhieuNhap = new JPanel();
        panelPhieuNhap.setLayout(new GridBagLayout());
        panelPhieuNhap.setBackground(Color.decode("#56c2f5"));
        panelPhieuNhap.setBounds(0,0,250,60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPhieuNhap.add(new JLabel(iconPhieuNhap), gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbPhieuNhap.setHorizontalAlignment(SwingConstants.LEFT);  // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelPhieuNhap.add(lbPhieuNhap, gbc);
        buttonPhieuNhap.add(panelPhieuNhap);
        buttonPhieuNhap.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                panelPhieuNhap.setBackground(Color.decode("#357ded"));
                panelPhieuNhap.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                panelPhieuNhap.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonPhieuNhap);
        
        
        //NÚT XUẤT HÀNG
        JButton buttonXuatHang = new JButton();
        buttonXuatHang.setLayout(null);
        buttonXuatHang.setBackground(Color.decode("#56c2f5"));
        buttonXuatHang.setBorderPainted(false);         // Ẩn viền của buttonNhapHang
        ImageIcon iconXuatHang = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\export.png");
        Image imgXuatHang = iconXuatHang.getImage().getScaledInstance(35, 35,java.awt.Image.SCALE_SMOOTH);
        iconXuatHang = new ImageIcon(imgXuatHang);
        
        JLabel lbXuatHang = new JLabel("EXPORT", JLabel.CENTER);
        lbXuatHang.setVerticalAlignment(JLabel.CENTER);
        lbXuatHang.setForeground(Color.WHITE);
        JPanel panelXuatHang = new JPanel();
        panelXuatHang.setLayout(new GridBagLayout());
        panelXuatHang.setBackground(Color.decode("#56c2f5"));
        panelXuatHang.setBounds(0,0,250,60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelXuatHang.add(new JLabel(iconXuatHang), gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbXuatHang.setHorizontalAlignment(SwingConstants.LEFT);  // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelXuatHang.add(lbXuatHang, gbc);
        buttonXuatHang.add(panelXuatHang);
        buttonXuatHang.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                panelXuatHang.setBackground(Color.decode("#357ded"));
                panelXuatHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                panelXuatHang.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonXuatHang);
        
        //Nút PHIẾU XUẤT
        JButton buttonPhieuXuat = new JButton();
        buttonPhieuXuat.setLayout(null);
        buttonPhieuXuat.setBackground(Color.decode("#56c2f5"));
        buttonPhieuXuat.setBorderPainted(false);         // Ẩn viền của buttonNhapHang
        ImageIcon iconPhieuXuat = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\documents.png");
        Image imgPhieuXuat = iconPhieuXuat.getImage().getScaledInstance(35, 35,java.awt.Image.SCALE_SMOOTH);
        iconPhieuXuat = new ImageIcon(imgPhieuXuat);
        
        JLabel lbPhieuXuat = new JLabel("DELIVERY", JLabel.CENTER);
        lbPhieuXuat.setVerticalAlignment(JLabel.CENTER);
        lbPhieuXuat.setForeground(Color.WHITE);
        JPanel panelPhieuXuat = new JPanel();
        panelPhieuXuat.setLayout(new GridBagLayout());
        panelPhieuXuat.setBackground(Color.decode("#56c2f5"));
        panelPhieuXuat.setBounds(0,0,250,60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPhieuXuat.add(new JLabel(iconPhieuXuat), gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);  // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelPhieuXuat.add(lbPhieuXuat, gbc);
        buttonPhieuXuat.add(panelPhieuXuat);
        buttonPhieuXuat.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                panelPhieuXuat.setBackground(Color.decode("#357ded"));
                panelPhieuXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                panelPhieuXuat.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonPhieuXuat);
        
        
        //NÚT KHO HÀNG
        JButton buttonKhoHang = new JButton();
        buttonKhoHang.setLayout(null);
        buttonKhoHang.setBackground(Color.decode("#56c2f5"));
        buttonKhoHang.setBorderPainted(false);         // Ẩn viền của buttonNhapHang
        ImageIcon iconKhoHang = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\warehouse.png");
        Image imgKhoHang = iconKhoHang.getImage().getScaledInstance(35, 35,java.awt.Image.SCALE_SMOOTH);
        iconKhoHang = new ImageIcon(imgKhoHang);
        
        JLabel lbKhoHang = new JLabel("WAREHOUSE", JLabel.CENTER);
        lbKhoHang.setVerticalAlignment(JLabel.CENTER);
        lbKhoHang.setForeground(Color.WHITE);
        JPanel panelKhoHang = new JPanel();
        panelKhoHang.setLayout(new GridBagLayout());
        panelKhoHang.setBackground(Color.decode("#56c2f5"));
        panelKhoHang.setBounds(0,0,250,60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelKhoHang.add(new JLabel(iconKhoHang), gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbKhoHang.setHorizontalAlignment(SwingConstants.LEFT);  // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelKhoHang.add(lbKhoHang, gbc);
        buttonKhoHang.add(panelKhoHang);
        buttonKhoHang.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                panelKhoHang.setBackground(Color.decode("#357ded"));
                panelKhoHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }   
            
            @Override
            public void mouseExited(MouseEvent e){
                panelKhoHang.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonKhoHang);
        
        //NÚT THỐNG KÊ
        // 1. Tạo JButton mới cho nút "THỐNG KÊ"
        JButton buttonThongKe = new JButton();
        buttonThongKe.setLayout(null);
        buttonThongKe.setBackground(Color.decode("#56c2f5"));
        buttonThongKe.setBorderPainted(false); // Ẩn viền của buttonThongKe

        // Tạo ImageIcon và thu nhỏ nó
        ImageIcon iconThongKe = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\analytics.png");
        Image imgThongKe = iconThongKe.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
        iconThongKe = new ImageIcon(imgThongKe);

        // 2. Tạo JLabel cho tên "THỐNG KÊ"
        JLabel lbThongKe = new JLabel("STATISTICS", JLabel.CENTER);
        lbThongKe.setVerticalAlignment(JLabel.CENTER);
        lbThongKe.setForeground(Color.WHITE);

        // 3. Tạo JPanel để chứa JButton và JLabel
        JPanel panelThongKe = new JPanel();
        panelThongKe.setLayout(new GridBagLayout());
        panelThongKe.setBackground(Color.decode("#56c2f5"));
        panelThongKe.setBounds(0, 0, 250, 60);

        // Thêm icon và label vào JPanel
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelThongKe.add(new JLabel(iconThongKe), gbc);

        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbThongKe.setHorizontalAlignment(SwingConstants.LEFT);  // Căn chỉnh label qua trái để gần icon
        panelThongKe.add(lbThongKe, gbc);

        // Thêm panel vào button
        buttonThongKe.add(panelThongKe);

        // 4. Thêm panelThongKe vào panelCenter
        panelCenter.add(buttonThongKe);

        // 5. Thiết lập MouseListener cho buttonThongKe
        buttonThongKe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panelThongKe.setBackground(Color.decode("#357ded"));
                panelThongKe.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                panelThongKe.setBackground(Color.decode("#56c2f5"));
            }
        });
        
        //NÚT NHÂN VIÊN
        JButton buttonNhanVien = new JButton();
        buttonNhanVien.setLayout(null);
        buttonNhanVien.setBackground(Color.decode("#56c2f5"));
        buttonNhanVien.setBorderPainted(false);         // Ẩn viền của buttonNhapHang
        ImageIcon iconNhanVien = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\employees.png");
        Image imgNhanVien= iconNhanVien.getImage().getScaledInstance(35, 35,java.awt.Image.SCALE_SMOOTH);
        iconNhanVien = new ImageIcon(imgNhanVien);
        
        JLabel lbNhanVien = new JLabel("EMPLOYEE", JLabel.CENTER);
        lbNhanVien.setVerticalAlignment(JLabel.CENTER);
        lbNhanVien.setForeground(Color.WHITE);
        JPanel panelNhanVien = new JPanel();
        panelNhanVien.setLayout(new GridBagLayout());
        panelNhanVien.setBackground(Color.decode("#56c2f5"));
        panelNhanVien.setBounds(0,0,250,60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelNhanVien.add(new JLabel(iconNhanVien), gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbNhanVien.setHorizontalAlignment(SwingConstants.LEFT);  // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelNhanVien.add(lbNhanVien, gbc);
        buttonNhanVien.add(panelNhanVien);
        buttonNhanVien.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                panelNhanVien.setBackground(Color.decode("#357ded"));
                panelNhanVien.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                panelNhanVien.setBackground(Color.decode("#56c2f5"));
            
            }
        });
        panelCenter.add(buttonNhanVien);
        
        //Nút TÀI KHOẢN
        JButton buttonTaiKhoan = new JButton();
        buttonTaiKhoan.setLayout(null);
        buttonTaiKhoan.setBackground(Color.decode("#56c2f5"));
        buttonTaiKhoan.setBorderPainted(false);         // Ẩn viền của buttonNhapHang
        ImageIcon iconTaiKhoan = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\user.png");
        Image imgTaiKhoan = iconTaiKhoan.getImage().getScaledInstance(35, 35,java.awt.Image.SCALE_SMOOTH);
        iconTaiKhoan = new ImageIcon(imgTaiKhoan);
        
        JLabel lbTaiKhoan = new JLabel("ACCOUNT", JLabel.CENTER);
        lbTaiKhoan.setVerticalAlignment(JLabel.CENTER);
        lbTaiKhoan.setForeground(Color.WHITE);
        JPanel panelTaiKhoan = new JPanel();
        panelTaiKhoan.setLayout(new GridBagLayout());
        panelTaiKhoan.setBackground(Color.decode("#56c2f5"));
        panelTaiKhoan.setBounds(0,0,250,60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelTaiKhoan.add(new JLabel(iconTaiKhoan), gbc);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        lbTaiKhoan.setHorizontalAlignment(SwingConstants.LEFT);  // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelTaiKhoan.add(lbTaiKhoan, gbc);
        buttonTaiKhoan.add(panelTaiKhoan);
        buttonTaiKhoan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                panelTaiKhoan.setBackground(Color.decode("#357ded"));
                panelTaiKhoan.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                panelTaiKhoan.setBackground(Color.decode("#56c2f5"));
            }
        });
        panelCenter.add(buttonTaiKhoan);
        
        thanhDieuHuong.add(panelCenter, BorderLayout.CENTER);
        
        
        JPanel panelBottom = new JPanel();
        panelBottom.setBackground(Color.red);
        panelBottom.setPreferredSize(new Dimension(256,60));
        panelBottom.setLayout(new GridLayout(1,1));
        thanhDieuHuong.add(panelBottom, BorderLayout.SOUTH);
        //NÚT ĐĂNG XUẤT
        JButton buttonDangXuat = new JButton();
        buttonDangXuat.setLayout(null);
        buttonDangXuat.setBackground(Color.decode("#56c2f5"));
        buttonDangXuat.setBorderPainted(false); // Ẩn viền của buttonNhapHang
        ImageIcon iconDangXuat = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\logout.png");
        Image imgDangXuat = iconDangXuat.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
        iconDangXuat = new ImageIcon(imgDangXuat);

        JLabel lbDangXuat = new JLabel("LOG OUT", JLabel.CENTER);
        lbDangXuat.setVerticalAlignment(JLabel.CENTER);
        lbDangXuat.setForeground(Color.WHITE);
        JPanel panelDangXuat = new JPanel();
        panelDangXuat.setLayout(new GridBagLayout());
        panelDangXuat.setBackground(Color.decode("#56c2f5"));
        panelDangXuat.setBounds(0, 0, 250, 60);
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelDangXuat.add(new JLabel(iconDangXuat), gbc);
        gbc.weightx = 0.7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        lbDangXuat.setHorizontalAlignment(SwingConstants.LEFT); // Căn cho label nhích qua bên trái để ở gần icon, nếu không sẽ ở xa trông kì
        panelDangXuat.add(lbDangXuat, gbc);
        buttonDangXuat.add(panelDangXuat);
        buttonDangXuat.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                panelDangXuat.setBackground(Color.decode("#357ded"));
                panelDangXuat.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e){
                panelDangXuat.setBackground(Color.decode("#56c2f5"));
            }
        });
//        thanhDieuHuong.add(buttonDangXuat);
        panelBottom.add(buttonDangXuat);
        mainPanel.add(thanhDieuHuong, BorderLayout.WEST);
        //######################################################################
        
        
        

        //######################################################################
        // PHAN NOI DUNG BEN PHAI
        JPanel noiDung = new JPanel(new CardLayout());
        noiDung.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(noiDung, BorderLayout.CENTER);

        // Thiết lập kích thước cho các phần
        int navigationWidth = f.getWidth() / 6; // Chiều rộng của thanhDieuHuong là 1/4 của frame
        int contentWidth = f.getWidth() - navigationWidth; // Chiều rộng của noiDung
        thanhDieuHuong.setPreferredSize(new Dimension(navigationWidth, f.getHeight())); // Đặt kích thước cho thanhDieuHuong
        noiDung.setPreferredSize(new Dimension(contentWidth, f.getHeight())); // Đặt kích thước cho noiDung
        
        // Định danh
        final String khohang = "KHO_HANG"; 
        final String sanpham = "SAN_PHAM";
        final String nhacungcap = "NHA_CUNG_CAP";
        final String nhaphang = "NHAP_HANG";
        final String phieunhap = "PHIEU_NHAP";
        final String xuathang = "XUAT_HANG";
        final String phieuxuat = "PHIEU_XUAT";
        final String nhanvien = "NHAN_VIEN";
        final String taikhoan = "TAI_KHOAN";
        final String thongke = "THONG_KE";
        final String dangxuat = "DANG_XUAT";
        
        // Thiết lập action listener & mouse listener cho buttonSanPham
        buttonSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SanPhamGUI sanPhamObj = new SanPhamGUI();
                noiDung.add(sanPhamObj, sanpham);
                CardLayout cardLayout = (CardLayout) noiDung.getLayout();
                cardLayout.show(noiDung, sanpham);
            }
        });
        
        
        // Thiết lập action listener cho buttonNhaCungCap
        buttonNhaCungCap.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                NhaCungCapGUI nhaCungCapObj = new NhaCungCapGUI();
                noiDung.add(nhaCungCapObj, nhacungcap);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, nhacungcap);
            }
        });
        
        // Thiết lập action listener cho buttonNhapHang
        buttonNhapHang.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                NhapHangGUI nhapHangObj = new NhapHangGUI();
                noiDung.add(nhapHangObj, nhaphang);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, nhaphang);
            }
        });
        
        // Thiết lập action listener cho buttonPhieuNhap
        buttonPhieuNhap.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                PhieuNhapGUI phieuNhapObj = new PhieuNhapGUI();
                noiDung.add(phieuNhapObj, phieunhap);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, phieunhap);
            }
        });
        
        
        // Thiết lập action listener cho buttonXuatHang
        buttonXuatHang.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                XuatHangGUI xuatHangObj = new XuatHangGUI();
                noiDung.add(xuatHangObj, xuathang);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, xuathang);
            }
        });
        
        
        // Thiết lập action listener cho buttonPhieuXuat
        buttonPhieuXuat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                PhieuXuatGUI phieuXuatObj = new PhieuXuatGUI();
                noiDung.add(phieuXuatObj, phieuxuat);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, phieuxuat);
            }
        });
        
        // Thiết lập action listener cho buttonKhoHang
        buttonKhoHang.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                KhoHangGUI khoHangObj = new KhoHangGUI();
                noiDung.add(khoHangObj, khohang);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, khohang);
            }
        });
        
        // Thiết lập action listener cho buttonThongKe
        buttonThongKe.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ThongKeGUI thongKeObj = new ThongKeGUI();
                noiDung.add(thongKeObj, thongke);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, thongke);
            }
        });
        
        // Thiết lập action listener cho buttonNhanVien
        buttonNhanVien.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                NhanVienGUI nhanVienObj = new NhanVienGUI();
                noiDung.add(nhanVienObj, nhanvien);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, nhanvien);
            }
        });
        
        // Thiết lập action listener cho buttonTaiKhoan
        buttonTaiKhoan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                TaiKhoanGUI taiKhoanObj = new TaiKhoanGUI();
                noiDung.add(taiKhoanObj, taikhoan);
                CardLayout cardLayout = (CardLayout)noiDung.getLayout();
                cardLayout.show(noiDung, taikhoan);
            }
        });
        
        buttonDangXuat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int choice = JOptionPane.showConfirmDialog(f, "Đăng xuất?", "Đăng xuất", JOptionPane.OK_CANCEL_OPTION);
                if(choice==JOptionPane.OK_OPTION){  //Nếu user click ok, thì đóng frame ứng dụng, mở cửa sổ login
                    f.dispose();
                    LoginGUI loginFormObj = new LoginGUI();
                    loginFormObj.setVisible(true);
//                    noiDung.add(loginFormObj, dangxuat);
//                    CardLayout cardLayout = (CardLayout)noiDung.getLayout();
//                    cardLayout.show(noiDung, dangxuat);
                }
                
            }
        });
        // Thêm giao diện trang chủ vào JPanel noiDung với định danh TRANG_CHU
        // Ví dụ: JPanel trangChuPanel là giao diện của trang chủ
        SanPhamGUI spView = new SanPhamGUI();
        noiDung.add(spView, sanpham);

        //######################################################################

        f.add(mainPanel);
        f.setVisible(true);
    }
    public void capNhatThongTinNguoiDung(String hoTen, String id, int viTri) {
        dataHoTen.setText(hoTen);
        dataID.setText(id);
        if(viTri==0){
            dataLoai.setText("Admin");
        }
        else if(viTri==1){
            dataLoai.setText("Nhân viên");
        }
        
    }

}

