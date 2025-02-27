package ExProject.controller;

import ExProject.Services.MotorManage;
import ExProject.Services.OtoManage;
import ExProject.Services.TruckManage;
import ExProject.models.Motor;
import ExProject.models.Oto;
import ExProject.models.Truck;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehicleController {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        int choice;
        Pattern truckPattern=Pattern.compile("^[0-9]{2}[C]-[0-9]{3}.[0-9]{2}$");
        Pattern otoPattern = Pattern.compile("^[0-9]{2}[A-B]-[0-9]{3}.[0-9]{2}$");
        Pattern motorPattern =Pattern.compile("^[0-9]{2}-[A-Z][A-Z0-9]-[0-9]{3}.[0-9]{2}$");

        TruckManage truckService = new TruckManage();
        OtoManage otoService = new OtoManage();
        MotorManage motorService = new MotorManage();
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG");
            System.out.println("Chọn chức năng ");
            System.out.println("1.Thêm mới phương tiện ");
            System.out.println("2.Hiển thị phương tiện");
            System.out.println("3.Xóa phương tiện ");
            System.out.println("4.Thoát ");
            System.out.println("Chức năng:  ");
            choice = scanner.nextInt();
            switch (choice) {

                case 1: {
                    int choice1;
                    System.out.println("1.Thêm xe tải ");
                    System.out.println("2.Thêm xe hơi");
                    System.out.println("3.Thêm xe máy");
                    System.out.println("Chọn: ");
                    choice1 = scanner.nextInt();
                    switch (choice1) {
                        case 1: {
                            Matcher matcher;
                            String ctrlSignal;
                            boolean check=true;
                            scanner.nextLine();
                            do {
                                System.out.println("Nhập biển số xe: ");
                                ctrlSignal = scanner.nextLine();
                                matcher= truckPattern.matcher(ctrlSignal);
                                for(int i=0;i<otoService.getSize();i++)
                                {
                                    if(otoService.getVehicle(i).getCtrlSignal().equals(ctrlSignal))
                                    {
                                        System.out.println("Đã trùng với biển số trước ");
                                        check=false;
                                        break;
                                    }
                                }
                               if(!matcher.matches())System.out.println("Biển số không đúng mời nhập lại");
                            }while(!matcher.matches()&&!check);

                            System.out.println("Nhập hãng xe: ");
                            String productLabel = scanner.nextLine();
                            System.out.println("Nhập năm sản xuất xe: ");
                            int yearProduct = scanner.nextInt();
                            System.out.println("Nhập chủ sở hữu xe: ");
                            scanner.nextLine();
                            String owner = scanner.nextLine();
                            System.out.println("Nhập trọng tải xe: ");
                            float weight = scanner.nextFloat();
                            Truck myTruck = new Truck(ctrlSignal, productLabel, yearProduct, owner, weight);
                            truckService.add(myTruck);
                            break;
                        }
                        case 2: {
                            Matcher matcher;
                            String ctrlSignal;
                            boolean check=true;
                            scanner.nextLine();
                            do {
                                System.out.println("Nhập biển số xe: ");
                                ctrlSignal = scanner.nextLine();
                                matcher= otoPattern.matcher(ctrlSignal);
                                for(int i=0;i<otoService.getSize();i++)
                                {
                                    if(otoService.getVehicle(i).getCtrlSignal().equals(ctrlSignal))
                                    {
                                        System.out.println("Đã trùng với biển số trước ");
                                        check=false;
                                        break;
                                    }
                                }
                                if(!matcher.matches())
                                {
                                    System.out.println("Biển số không đúng mời nhập lại");
                                    check=false;
                                }
                            }while(!check);
                            System.out.println("Nhập hãng xe: ");
                            String productLabel = scanner.nextLine();
                            System.out.println("Nhập năm sản xuất xe: ");
                            int yearProduct = scanner.nextInt();
                            System.out.println("Nhập chủ sở hữu xe: ");
                            scanner.nextLine();
                            String owner = scanner.nextLine();
                            System.out.println("Nhập kiểu xe: ");
                            String type = scanner.nextLine();
                            System.out.println("Nhập số chỗ ngồi: ");
                            int seat = scanner.nextInt();
                            Oto myOto = new Oto(ctrlSignal, productLabel, yearProduct, owner, seat, type);
                            otoService.add(myOto);
                            break;
                        }

                        case 3: {
                            Matcher matcher;
                            String ctrlSignal;
                            scanner.nextLine();
                            do {
                                System.out.println("Nhập biển số xe: ");
                                ctrlSignal = scanner.nextLine();
                                matcher= motorPattern.matcher(ctrlSignal);
                                System.out.println("Biển số không đúng mời nhập lại");
                            }while(!matcher.matches());
                            System.out.println("Nhập hãng xe: ");
                            String productLabel = scanner.nextLine();
                            System.out.println("Nhập năm sản xuất xe: ");
                            int yearProduct = scanner.nextInt();
                            System.out.println("Nhập chủ sở hữu xe: ");
                            scanner.nextLine();
                            String owner = scanner.nextLine();
                            System.out.println("Nhập công suất:  ");
                            float power = scanner.nextFloat();
                            Motor myMotor = new Motor(ctrlSignal, productLabel, yearProduct, owner, power);
                            motorService.add(myMotor);
                            break;
                        }

                        case 4:
                            break;
                        default: {
                            System.out.println("Lựa chọn không hợp lệ mời nhập lại.");
                            break;
                        }
                    }
                    break;
                }

                case 2: {
                    int choice2;
                    System.out.println("1.Hiển thị xe tải ");
                    System.out.println("2.Hiển thị xe hơi");
                    System.out.println("3.Hiển thị xe máy");
                    System.out.println("Chọn: ");
                    choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1: {
                            truckService.display();
                            break;

                        }
                        case 2: {
                            otoService.display();
                            break;
                        }
                        case 3: {
                            motorService.display();
                            break;
                        }
                    }
                    break;
                }

                case 3: {
                    int choice3;
                    System.out.println("1.Xóa xe tải ");
                    System.out.println("2.Xóa xe hơi");
                    System.out.println("3.Xóa xe máy");
                    System.out.println("Chọn: ");
                    choice3 = scanner.nextInt();
                    switch (choice3) {
                        case 1: {
                            scanner.nextLine();
                            System.out.println("NHập biển số cần xóa: ");
                            String signal = scanner.nextLine();
                            truckService.delete(signal);
                            break;
                        }
                        case 2: {
                            scanner.nextLine();
                            System.out.println("NHập biển số cần xóa: ");
                            String signal = scanner.nextLine();
                            otoService.delete(signal);
                            break;
                        }
                        case 3: {
                            scanner.nextLine();
                            System.out.println("NHập biển số cần xóa: ");
                            String signal = scanner.nextLine();
                            motorService.delete(signal);
                            break;
                        }
                        default: {
                            System.out.println("Lựa chọn không hợp lệ");
                        }
                    }
                }
                case 4:
                    break;
                default: {
                    System.out.println("Bye");
                    break;
                }
            }
        } while (choice != 4);
    }
}
