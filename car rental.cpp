// ================= Car Rental System =================
// ================= By Samuel Yosef  =================
// ================= Dec 16, 2025 =================

#include <iostream>
#include <string>
using namespace std;

// Structures

struct car {
    int id;
    string name;
    double price;
    string availability;
};

struct customer {
    int id;
    string name;
    string phone;
    car rentals[100];
    int rented_count = 0;
};

struct dashboard {
    int total_cars = 0;
    int total_available = 0;
    int total_rented = 0;
    int total_customer = 0;
    double total_income = 0;
};


// global data

car car_list[100];
customer customer_list[100];
dashboard admin;

int car_count = 0;
int customer_count = 0;
int logged_user_id = -1;

// ny helpers 

double calculate_price(double perday, int days) {
    return perday * days;
}

// admins only usable functin

void add_car() {
    car c;
    c.id = car_count + 1;

    cout << "Enter car name: ";
    cin >> c.name;
    cout << "Enter price per day: ";
    cin >> c.price;

    c.availability = "available";
    car_list[car_count++] = c;

    admin.total_cars++;
    admin.total_available++;

    cout << "Car added successfully!\n";
}

void add_customer() {
    customer c;
    c.id = customer_count + 1;

    cout << "Enter customer name: ";
    cin >> c.name;
    cout << "Enter phone: ";
    cin >> c.phone;

    customer_list[customer_count++] = c;
    admin.total_customer++;

    cout << "Customer added successfully!\n";
}

void show_dashboard() {
    cout << "\n===== DASHBOARD =====\n";
    cout << "Total Cars: " << admin.total_cars << endl;
    cout << "Available Cars: " << admin.total_available << endl;
    cout << "Rented Cars: " << admin.total_rented << endl;
    cout << "Total Customers: " << admin.total_customer << endl;
    cout << "Total Income: " << admin.total_income << endl;
}

// for normal user only to rent or retrun

void list_available_cars() {
    bool found = false;
    cout << "\nAvailable Cars:\n";

    for (int i = 0; i < car_count; i++) {
        if (car_list[i].availability == "available") {
            cout << "ID: " << car_list[i].id
                 << " | Name: " << car_list[i].name
                 << " | Price/day: " << car_list[i].price << endl;
            found = true;
        }
    }

    if (!found)
        cout << "No available cars!\n";
}

void rent_car() {
    if (logged_user_id < 0 || logged_user_id >= customer_count) {
        cout << "User not found!\n";
        return;
    }

    int car_id, days;
    list_available_cars();

    cout << "Select car ID: ";
    cin >> car_id;

    if (car_id < 1 || car_id > car_count) {
        cout << "Car not found!\n";
        return;
    }

    if (car_list[car_id - 1].availability != "available") {
        cout << "Car not available!\n";
        return;
    }

    cout << "Enter rental days: ";
    cin >> days;

    double total = calculate_price(car_list[car_id - 1].price, days);
    cout << "Total price: " << total << endl;

    car_list[car_id - 1].availability = "rented";

    customer_list[logged_user_id].rentals[
        customer_list[logged_user_id].rented_count++
    ] = car_list[car_id - 1];

    admin.total_rented++;
    admin.total_available--;
    admin.total_income += total;

    cout << "Car rented successfully!\n";
}

void return_car() {
    int car_id;
    cout << "Enter car ID to return: ";
    cin >> car_id;

    if (car_id < 1 || car_id > car_count) {
        cout << "Car not found!\n";
        return;
    }

    if (car_list[car_id - 1].availability != "rented") {
        cout << "Car is not rented!\n";
        return;
    }

    car_list[car_id - 1].availability = "available";
    admin.total_rented--;
    admin.total_available++;

    cout << "Car returned successfully!\n";
}

// good cli display

void admin_menu() {
    int choice;
    do {
        cout << "\n--- ADMIN MENU ---\n";
        cout << "1. Add Car\n";
        cout << "2. Add Customer\n";
        cout << "3. View Dashboard\n";
        cout << "0. Logout\n";
        cout << "Choose: ";
        cin >> choice;

        switch (choice) {
            case 1: add_car(); break;
            case 2: add_customer(); break;
            case 3: show_dashboard(); break;
            case 0: cout << "Logging out...\n"; break;
            default: cout << "Invalid option!\n";
        }
    } while (choice != 0);
}

void customer_menu() {
    int choice;
    do {
        cout << "\n--- CUSTOMER MENU ---\n";
        cout << "1. Rent Car\n";
        cout << "2. Return Car\n";
        cout << "0. Quit\n";
        cout << "Choose: ";
        cin >> choice;

        switch (choice) {
            case 1: rent_car(); break;
            case 2: return_car(); break;
            case 0: cout << "Logging out...\n"; break;
            default: cout << "Invalid option!\n";
        }
    } while (choice != 0);
}

// user login simulator ....

void login() {
    string username, password;
    logged_user_id = -1;

    cout << "\n===== LOGIN =====\n";
    cout << "Username: ";
    cin >> username;
    cout << "Password: ";
    cin >> password;

    if (username == "admin" && password == "admin") {
        admin_menu();
        return;
    }

    // check existing customer
    for (int i = 0; i < customer_count; i++) {
        if (customer_list[i].name == username) {
            logged_user_id = i;
            customer_menu();
            return;
        }
    }

    // create new customer
    customer c;
    c.id = customer_count;
    c.name = username;
    c.phone = "N/A";

    customer_list[customer_count++] = c;
    logged_user_id = c.id;
    admin.total_customer++;

    customer_menu();
}

// THE MAIN FUNCTIN

int main() {
    while (true) {
        login();   // always return to login after logout so if i want to close Ctrl+c is the option :)
    }
    return 0;
}
