/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.NhaCungCapDTO;
import BUS.NhaCungCapBUS;
import Lop.PopupNhaCungCap;
import DAO.NhaCungCapDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ACER
 */
public class NhaCungCapGUI extends JPanel {
    private NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    private JTable table = new JTable();
    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<NhaCungCapDTO> arrNhaCungCap = new ArrayList<>();
    private JPanel content1;
    private JTextField tfTimKiem;
    private JComboBox cb;
    //Constructor
    public NhaCungCapGUI(){
        initComponents();
        loadNhaCungCapList();
    }
    
    
    ////////////////////////////// METHODS //////////////////////////////////////
    private void initComponents(){  
        table.setDefaultEditor(Object.class, null);
        setBackground(Color.decode("#6c757d")); 
        setLayout(new GridBagLayout());
        
        JPanel functionBar = new JPanel();
        functionBar.setBackground(Color.WHITE);
        functionBar.setLayout(new GridBagLayout());
        functionBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5)); //Để cái functionBar nó cách viền 5px ở các cạnh, riêng bottom thì cách 10px
        content1 = new JPanel();
        content1.setBackground(Color.WHITE);
        content1.setLayout(new GridBagLayout());
        content1.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5)); //Để cái content nó cách viền 5px ở các cạnh, riêng canh top thì cách 10px
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(functionBar, gbc);
        gbc.weighty = 0.8;
        gbc.gridy = 1;
        add(content1, gbc);
        
        //Tạo 2 panel trái, phải chứa các chức năng
        JPanel leftFunction = new JPanel();
        leftFunction.setBackground(Color.WHITE);
        leftFunction.setBorder(BorderFactory.createTitledBorder("Functions"));
        JPanel rightFunction = new JPanel();
        rightFunction.setBackground(Color.WHITE);
        rightFunction.setBorder(BorderFactory.createTitledBorder("Searching"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        functionBar.add(leftFunction, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.6;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        functionBar.add(rightFunction, gbc);

        JScrollPane sp = new JScrollPane(table);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        content1.add(sp, gbc);
        
        leftFunction.setLayout(null);
        rightFunction.setLayout(new GridBagLayout());
        
        //Tạo và thêm các panel chứa các nút chức năng ở leftFunction
        JPanel panelThem = new JPanel();
        JPanel panelXoa = new JPanel();
        JPanel panelSua = new JPanel();
        JPanel panelXuatExcel = new JPanel();
        JPanel panelXemChiTiet = new JPanel();
        panelThem.setBackground(Color.WHITE);
        panelXoa.setBackground(Color.WHITE);
        panelSua.setBackground(Color.WHITE);
        panelXuatExcel.setBackground(Color.WHITE);
        panelXemChiTiet.setBackground(Color.WHITE);
        
        panelThem.setBounds(20, 20, 50, 60);
        panelThem.setLayout(null);
        panelXoa.setBounds(70,20,50,60);
        panelXoa.setLayout(null);
        panelSua.setBounds(120,20,50,60);
        panelSua.setLayout(null);
        panelXemChiTiet.setBounds(170,20,80,60);
        panelXemChiTiet.setLayout(null);
        panelXuatExcel.setBounds(270,20,80,60);
        panelXuatExcel.setLayout(null);
        
        
        leftFunction.add(panelThem);
        leftFunction.add(panelXoa);
        leftFunction.add(panelSua);
        leftFunction.add(panelXemChiTiet);
        leftFunction.add(panelXuatExcel);
        
        
        
        //Thêm các nút chức năng vào các panel ở leftFunction
        JButton buttonThem, buttonXoa, buttonSua, buttonXemChiTiet, buttonXuatExcel, buttonTimKiem, buttonLamMoi;
        
        buttonThem = new JButton();
        buttonThem.setBackground(Color.WHITE);
        ImageIcon iconAdd = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\add.png");
        Image img = iconAdd.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);  //Chỉnh sửa kích thước ảnh
        iconAdd = new ImageIcon(img);       //Tạo lại iconAdd bằng ảnh vừa được chỉnh sửa kích thước
        
        JLabel lbThem = new JLabel("Add", JLabel.CENTER);
        lbThem.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonThem = new JPanel();
        panelButtonThem.setLayout(new BorderLayout());
        panelButtonThem.setBackground(Color.WHITE);
        panelButtonThem.setBounds(0,0,50,60);
        panelButtonThem.add(new JLabel(iconAdd), BorderLayout.CENTER);  //Add ảnh vào vị trí giữa button
        panelButtonThem.add(lbThem, BorderLayout.SOUTH);    //Add label "Thêm" vào bottom của button
        
        buttonThem.setLayout(null);
        buttonThem.setBounds(0,0,50,60);
        buttonThem.add(panelButtonThem);
        buttonThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPerformed(table);
            }
        });
        buttonThem.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonThem.setBackground(Color.decode("#D6D6D6")); // Đổi màu khi hover vào
                buttonThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonThem.setBackground(Color.decode("#D6D6D6"));
                
            }
    
            @Override
            public void mouseExited(MouseEvent e){
                buttonThem.setBackground(Color.WHITE); // Quy lại màu bình thường khi hover ra
                panelButtonThem.setBackground(Color.WHITE);
            }
        });
        
        buttonXoa = new JButton();
        buttonXoa.setBackground(Color.WHITE);
        ImageIcon iconDelete = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\delete.png");
        Image img2 = iconDelete.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
        iconDelete = new ImageIcon(img2);
        
        JLabel lbXoa = new JLabel("Delete", JLabel.CENTER);
        lbXoa.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonXoa = new JPanel();
        panelButtonXoa.setLayout(new BorderLayout());
        panelButtonXoa.setBackground(Color.WHITE);
        panelButtonXoa.setBounds(0,0,50,60);
        panelButtonXoa.add(new JLabel(iconDelete), BorderLayout.CENTER);
        panelButtonXoa.add(lbXoa, BorderLayout.SOUTH);
        
        buttonXoa.setLayout(null);
        buttonXoa.setBounds(0,0,50,60);
        buttonXoa.add(panelButtonXoa);
        buttonXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                deletePerformed(table);
            }
        });
        buttonXoa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonXoa.setBackground(Color.decode("#D6D6D6")); // Đổi màu khi hover vào
                buttonXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonXoa.setBackground(Color.decode("#D6D6D6"));
                
            }
    
            @Override
            public void mouseExited(MouseEvent e){
                buttonXoa.setBackground(Color.WHITE); // Quy lại màu bình thường khi hover ra
                panelButtonXoa.setBackground(Color.WHITE);
            }
        });
        
        buttonSua = new JButton();
        buttonSua.setBackground(Color.WHITE);
        ImageIcon iconFix = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\pencil.png");
        Image img3 = iconFix.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
        iconFix = new ImageIcon(img3);
        
        JLabel lbSua = new JLabel("Update", JLabel.CENTER);
        lbSua.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonSua = new JPanel();
        panelButtonSua.setLayout(new BorderLayout());
        panelButtonSua.setBackground(Color.WHITE);
        panelButtonSua.setBounds(0,0,50,60);
        panelButtonSua.add(new JLabel(iconFix), BorderLayout.CENTER);
        panelButtonSua.add(lbSua, BorderLayout.SOUTH);
        
        buttonSua.setLayout(null);
        buttonSua.setBounds(0,0,50,60);
        buttonSua.add(panelButtonSua);
        buttonSua.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updatePerformed(table);
            }
        });
        buttonSua.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonSua.setBackground(Color.decode("#D6D6D6"));
                buttonSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonSua.setBackground(Color.decode("#D6D6D6"));
                
            }
            @Override
            public void mouseExited(MouseEvent e){
                buttonSua.setBackground(Color.WHITE);
                panelButtonSua.setBackground(Color.WHITE);
            }
        });
        
        buttonXemChiTiet = new JButton();
        buttonXemChiTiet.setBackground(Color.WHITE);
        ImageIcon iconSee = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\eye2.jpg");
        Image img4 = iconSee.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
        iconSee = new ImageIcon(img4);
        
        JLabel lbXem = new JLabel("Detail", JLabel.CENTER);
        lbXem.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonXem = new JPanel();
        panelButtonXem.setLayout(new BorderLayout());
        panelButtonXem.setBackground(Color.WHITE);
        panelButtonXem.setBounds(0,0,80,60);
        panelButtonXem.add(new JLabel(iconSee), BorderLayout.CENTER);
        panelButtonXem.add(lbXem, BorderLayout.SOUTH);
        
        buttonXemChiTiet.setLayout(null);
        buttonXemChiTiet.setBounds(0,0,80,60);
        buttonXemChiTiet.add(panelButtonXem);
        buttonXemChiTiet.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                xemPerformed(table);
            }
        });
        buttonXemChiTiet.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonXemChiTiet.setBackground(Color.decode("#D6D6D6"));
                buttonXemChiTiet.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonXem.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                buttonXemChiTiet.setBackground(Color.WHITE);
                panelButtonXem.setBackground(Color.WHITE);
            }
        });
        
        buttonXuatExcel = new JButton();
        buttonXuatExcel.setBackground(Color.WHITE);
        ImageIcon iconXuat = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\excel1.png");
        Image img5 = iconXuat.getImage().getScaledInstance(35,35, java.awt.Image.SCALE_SMOOTH);
        iconSee = new ImageIcon(img5);
        
        JLabel lbXuat = new JLabel("Excel", JLabel.CENTER);
        lbXuat.setVerticalAlignment(JLabel.BOTTOM);
        
        JPanel panelButtonXuat = new JPanel();
        panelButtonXuat.setLayout(new BorderLayout());
        panelButtonXuat.setBackground(Color.WHITE);
        panelButtonXuat.setBounds(0,0,80,60);
        panelButtonXuat.add(new JLabel(iconSee), BorderLayout.CENTER);
        panelButtonXuat.add(lbXuat, BorderLayout.SOUTH);
        
        buttonXuatExcel.setLayout(null);
        buttonXuatExcel.setBounds(0,0,80,60);
        buttonXuatExcel.add(panelButtonXuat);
        buttonXuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excelExporter ex = new excelExporter();
                ex.excelExporterNhaCungCap();
                JOptionPane.showMessageDialog(null, "Excel file exported successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonXuatExcel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonXuatExcel.setBackground(Color.decode("#D6D6D6"));
                buttonXuatExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonXuat.setBackground(Color.decode("#D6D6D6"));
            }
            @Override
            public void mouseExited(MouseEvent e){
                buttonXuatExcel.setBackground(Color.WHITE);
                panelButtonXuat.setBackground(Color.WHITE);
            }
        });
        
        panelThem.add(buttonThem);
        panelXoa.add(buttonXoa);
        panelSua.add(buttonSua);
        panelXemChiTiet.add(buttonXemChiTiet);
        panelXuatExcel.add(buttonXuatExcel);
        
        
        
        
        //Tạo và thêm các panel chứa các chức năng tìm kiếm
        JPanel panelCombobox = new JPanel();
        JPanel panelSearchbox = new JPanel();
        JPanel panelLamMoi = new JPanel();
        panelCombobox.setBackground(Color.WHITE);
        panelCombobox.setLayout(null);
        panelSearchbox.setBackground(Color.WHITE);    
        panelSearchbox.setLayout(null);
        panelLamMoi.setBackground(Color.WHITE);
        panelLamMoi.setLayout(null);
        
        gbc = new GridBagConstraints(); // Resetting GridBagConstraints

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        gbc.weighty = 0.3;
        gbc.fill = GridBagConstraints.BOTH; 
        rightFunction.add(panelCombobox, gbc);
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.gridx = 1;
        rightFunction.add(panelSearchbox, gbc);
        gbc.weightx = 0.2;
        gbc.weighty = 0.2;
        gbc.gridx = 2;
        rightFunction.add(panelLamMoi, gbc);
        
        
        //Tạo combobox
        String combo[] = {"All", "A-Z", "Z-A", "City"};
        cb = new JComboBox(combo);
        cb.setBounds(10,20,120,30);
        panelCombobox.add(cb);
        
        cb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String selectedOption = (String)cb.getSelectedItem();
                switch(selectedOption){
                    case "A-Z":
                        sortAZ();
                        break;
                    case "Z-A":
                        sortZA();
                        break;
                    case "Theo thành phố":
                    default:
                        break;
                }
            }
        });
        
        //Tạo textfield để nhập tìm kiếm
        tfTimKiem = new JTextField();
        tfTimKiem.setBounds(10,20,210,30);
        // Tạo nút tìm kiếm
        buttonTimKiem = new JButton();
        buttonTimKiem.setBackground(Color.red);
        ImageIcon iconSearch = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\search.png");
        Image imgTimKiem = iconSearch.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);  
        iconSearch = new ImageIcon(imgTimKiem);

        JLabel lbTimKiem = new JLabel("Search", JLabel.CENTER);
        lbTimKiem.setVerticalAlignment(JLabel.CENTER);

        JPanel panelButtonTimKiem = new JPanel();
        panelButtonTimKiem.setLayout(new BorderLayout());
        panelButtonTimKiem.setBackground(Color.WHITE);
        panelButtonTimKiem.setBounds(0, 0, 90, 40);
        panelButtonTimKiem.add(new JLabel(iconSearch), BorderLayout.WEST);  // Thêm iconSearch vào vị trí phù hợp
        panelButtonTimKiem.add(lbTimKiem, BorderLayout.CENTER);    // Thêm label "Tìm kiếm" vào vị trí phù hợp

        buttonTimKiem.setLayout(null); // Sử dụng BorderLayout cho buttonTimKiem
        buttonTimKiem.add(panelButtonTimKiem); // Thêm panel chứa icon và label vào buttonTimKiem
        buttonTimKiem.setBounds(240, 13, 90, 40);
        panelSearchbox.add(tfTimKiem); panelSearchbox.add(buttonTimKiem);
        
        buttonTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPerformed(table);
            }
        });
        buttonTimKiem.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonTimKiem.setBackground(Color.decode("#D6D6D6")); // Đổi màu khi hover vào
                buttonTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonTimKiem.setBackground(Color.decode("#D6D6D6"));
                
            }
    
            @Override
            public void mouseExited(MouseEvent e){
                buttonTimKiem.setBackground(Color.WHITE); // Quy lại màu bình thường khi hover ra
                panelButtonTimKiem.setBackground(Color.WHITE);
            }
        });
        //Tạo nút Làm mới để reset tìm kiếm
        buttonLamMoi = new JButton();
        buttonLamMoi.setBackground(Color.red);
        ImageIcon iconRefresh = new ImageIcon("C:\\Users\\ACER\\Dropbox\\My PC (LAPTOP-UGP9QJUT)\\Documents\\NetBeansProjects\\Warehouse_Management2\\src\\Images\\refresh.png");
        Image imgLamMoi = iconRefresh.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
        iconRefresh = new ImageIcon(imgLamMoi);
        
        JLabel lbLamMoi = new JLabel("Refresh", JLabel.CENTER);
        lbLamMoi.setVerticalAlignment(JLabel.CENTER);
        
        JPanel panelButtonLamMoi = new JPanel();
        panelButtonLamMoi.setLayout(new BorderLayout());
        panelButtonLamMoi.setBackground(Color.WHITE);
        panelButtonLamMoi.setBounds(0,0,105,40);
        panelButtonLamMoi.add(new JLabel(iconRefresh), BorderLayout.WEST);
        panelButtonLamMoi.add(lbLamMoi, BorderLayout.CENTER);
        
        buttonLamMoi.setLayout(null);
        buttonLamMoi.add(panelButtonLamMoi);
        buttonLamMoi.setBounds(10,13,105,40);
        panelLamMoi.add(buttonLamMoi);
        buttonLamMoi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                buttonLamMoi.setBackground(Color.decode("#D6D6D6"));
                buttonLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelButtonLamMoi.setBackground(Color.decode("#D6D6D6"));
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                buttonLamMoi.setBackground(Color.WHITE);
                panelButtonLamMoi.setBackground(Color.WHITE);
            }
        });
        buttonLamMoi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                lamMoi();
            }
        });
        panelLamMoi.add(buttonLamMoi);
    }
    
    private void loadNhaCungCapList(){
        table.setModel(model);
        model.addColumn("Mã nhà cung cấp");
        model.addColumn("Tên nhà cung cấp");
        model.addColumn("Địa chỉ");
        model.addColumn("Số điện thoại");

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(180);
        columnModel.getColumn(1).setPreferredWidth(350);
        columnModel.getColumn(2).setPreferredWidth(450);
        columnModel.getColumn(3).setPreferredWidth(160);

//        // Tạo một DefaultTableCellRenderer và đặt căn giữa
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//
//
//        for (int i = 0; i < columnModel.getColumnCount(); i++) {
//            columnModel.getColumn(i).setCellRenderer(centerRenderer);
//        }

        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Prevent automatic resizing
        table.setRowHeight(30);
        arrNhaCungCap = nccBUS.getAllNhaCungCap();
        for(int i = 0; i < arrNhaCungCap.size(); i++){
            NhaCungCapDTO ncc = arrNhaCungCap.get(i);
            String mancc = ncc.getMaNCC();
            String tenncc = ncc.getTenNCC();
            String diachi = ncc.getDiaChiNCC();
            String sdt = ncc.getSdt();

            Object[] row = {mancc, tenncc, diachi, sdt};
            model.addRow(row);
        }
    }
    
    private void lamMoi(){
        //Xóa tất cả các dòng trong model table
        model.setRowCount(0);
        loadNhaCungCapList();
        tfTimKiem.setText("");
        cb.setSelectedItem("Tất cả");
        
    }
    
    private void sortAZ(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexSort = 1; // 1 là chỉ số cột tên máy, cần sắp xếp
        sortKeys.add(new RowSorter.SortKey(columnIndexSort, SortOrder.ASCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
    
    private void sortZA(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        int columnIndexSort = 1; // 1 là chỉ số cột tên máy, cần sắp xếp
        sortKeys.add(new RowSorter.SortKey(columnIndexSort, SortOrder.DESCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }
    
    private void addPerformed(JTable tb){
        PopupNhaCungCap frameThem = new PopupNhaCungCap("Thêm nhà cung cấp", "THÊM NHÀ CUNG CẤP","add");
    }
    private void deletePerformed(JTable tb){
        int selectedRow = table.getSelectedRow();
        if(selectedRow != -1){
            int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhà cung cấp?", "Xác nhận xóa", JOptionPane.OK_CANCEL_OPTION);
            if(dialogResult == JOptionPane.OK_OPTION){
                String mancc = (String)model.getValueAt(selectedRow, 0);
                String message = nccBUS.deleteNhaCungCap(mancc);
                if(message.equals("Xóa nhà cung cấp thành công")){
                    model.removeRow(selectedRow);
                    arrNhaCungCap.remove(selectedRow);
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void updatePerformed(JTable tb){
        int selected = table.getSelectedRow();
        if(selected!=-1){
            PopupNhaCungCap frameSua = new PopupNhaCungCap("Sửa nhà cung cấp", "SỬA NHÀ CUNG CẤP", "fix");
        }
        else
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để sửa", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
    private void searchPerformed(JTable tb){
        String searchContent = tfTimKiem.getText().trim();
        if(!searchContent.isEmpty()){
            ArrayList<NhaCungCapDTO> dsTimKiem = new ArrayList<>();
            
            boolean found = false;
            for(NhaCungCapDTO ncc: arrNhaCungCap){
                if(ncc.getMaNCC().toLowerCase().contains(searchContent.toLowerCase()) ||
                   ncc.getTenNCC().toLowerCase().contains(searchContent.toLowerCase())||
                   ncc.getDiaChiNCC().toLowerCase().contains(searchContent.toLowerCase())||
                   ncc.getSdt().toLowerCase().contains(searchContent.toLowerCase()))
                {
                    dsTimKiem.add(ncc);
                    found = true;
                }
            }
            
            if(!found){
                JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung cấp");
                lamMoi();
                return;
            }
            
            DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
            tableModel.setRowCount(0);
            
            for(NhaCungCapDTO nhaCungCap: dsTimKiem){
                Object[] row ={
                    nhaCungCap.getMaNCC(),
                    nhaCungCap.getTenNCC(),
                    nhaCungCap.getDiaChiNCC(),
                    nhaCungCap.getSdt()
                };
                tableModel.addRow(row);
            }
        }else{
            JOptionPane.showMessageDialog(this,"Vui lòng nhập thông tin tìm kiếm");
            lamMoi();
        }
    }

    
    private void xemPerformed(JTable tb){
        int selectedRow = table.getSelectedRow();
        if(selectedRow!=-1){
            JLabel lbmancc, lbtenncc, lbdiachi, lbsdt;
            JTextField tfmancc, tftenncc, tfdiachi, tfsdt;
            JFrame f = new JFrame("Thông tin");
        
            f.setLayout(new GridBagLayout());

            JPanel banner = new JPanel();
            banner.setBackground(Color.decode("#56c2f5"));
            JPanel content = new JPanel();
            content.setBackground(Color.GREEN);
            content.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1.0;
            gbc.weighty = 0.15;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 0;
            gbc.gridy = 0;
            f.add(banner, gbc);
            gbc.weighty = 0.85;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridy = 1;
            f.add(content, gbc);

            banner.setLayout(new GridBagLayout());
            JLabel lb = new JLabel("THÔNG NHÀ CUNG CẤP");
            Font font = new Font("Arial", Font.BOLD, 15);
            lb.setFont(font);
            lb.setForeground(Color.WHITE);
            lb.setHorizontalAlignment(JLabel.CENTER);
            lb.setVerticalAlignment(JLabel.CENTER);
            GridBagConstraints gbcLabel = new GridBagConstraints();
            gbcLabel.weightx = 1.0;
            gbcLabel.weighty = 1.0;
            banner.add(lb, gbcLabel);

            JPanel pnMa, pnTen, pnDiaChi, pnSdt;
            pnMa = new JPanel();
            pnMa.setBackground(Color.WHITE);
            pnTen = new JPanel();
            pnTen.setBackground(Color.WHITE);
            pnDiaChi = new JPanel();
            pnDiaChi.setBackground(Color.WHITE);
            pnSdt = new JPanel();
            pnSdt.setBackground(Color.WHITE);


            gbc.gridx = 0;
            gbc.gridy = 0;
            content.add(pnMa, gbc);
            gbc.gridy = 1;
            content.add(pnTen, gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            content.add(pnDiaChi, gbc);
            gbc.gridy = 1;
            content.add(pnSdt, gbc);


            lbmancc = new JLabel("Mã nhà cung cấp");
            lbtenncc = new JLabel("Tên nhà cung cấp");
            lbdiachi = new JLabel("Địa chỉ");
            lbsdt = new JLabel("SĐT");

            tfmancc = new JTextField();
            tftenncc = new JTextField();
            tfdiachi = new JTextField();
            tfsdt = new JTextField();

            lbmancc.setBounds(20,10,100,20);
            tfmancc.setBounds(20,30,180,30);
            pnMa.setLayout(null);
            pnMa.add(lbmancc);  pnMa.add(tfmancc);

            lbtenncc.setBounds(20,10,110,20);
            tftenncc.setBounds(20,30,250,30);
            pnTen.setLayout(null);
            pnTen.add(lbtenncc);    pnTen.add(tftenncc);

            lbdiachi.setBounds(0,10,110,20);
            tfdiachi.setBounds(0,30,335,30);
            pnDiaChi.setLayout(null);
            pnDiaChi.add(lbdiachi); pnDiaChi.add(tfdiachi);

            lbsdt.setBounds(0,10,110,20);
            tfsdt.setBounds(0,30,100,30);
            pnSdt.setLayout(null);
            pnSdt.add(lbsdt);   pnSdt.add(tfsdt);


            String maNCC = table.getValueAt(selectedRow, 0).toString();
            NhaCungCapDAO nccDAO = new NhaCungCapDAO();
            NhaCungCapDTO ncc = nccDAO.getByID(maNCC);
            if(ncc!=null){
                tfmancc.setText(ncc.getMaNCC());
                tftenncc.setText(ncc.getTenNCC());
                tfdiachi.setText(ncc.getDiaChiNCC());
                tfsdt.setText(ncc.getSdt());
            }

            // phương thức setEditable(false) set các textfield ở mode read only
            tfmancc.setEditable(false);
            tftenncc.setEditable(false);
            tfdiachi.setEditable(false);
            tfsdt.setEditable(false);

            // phương thức setFocusable(false) không cho click vào các textfield
            tfmancc.setFocusable(false);
            tftenncc.setFocusable(false);
            tfdiachi.setFocusable(false);
            tfsdt.setFocusable(false);

            f.setSize(720,400);
            f.setResizable(false);
            f.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng để xem thông tin");
        }
        
    }
    
}
