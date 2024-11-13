import os

# Define the project base directory
base_dir = "src/main/java/com/classicmodels/classicmodelsservice"

# Directory structure
structure = {
    "": "ClassicModelsApplication.java",
    "entity": [
        "ProductLine.java", "Product.java", "Office.java", "Employee.java", 
        "Customer.java", "Payment.java", "Order.java", "OrderDetail.java", "OrderDetailPK.java"
    ],
    "repository": [
        "ProductLineRepository.java", "ProductRepository.java", "OfficeRepository.java", 
        "EmployeeRepository.java", "CustomerRepository.java", "PaymentRepository.java", 
        "OrderRepository.java", "OrderDetailRepository.java"
    ],
    "service": [
        "ProductLineService.java", "ProductService.java", "OfficeService.java", 
        "EmployeeService.java", "CustomerService.java", "PaymentService.java", 
        "OrderService.java", "OrderDetailService.java"
    ],
    "serviceImpl": [  # Add this line for service implementations
        "ProductLineServiceImpl.java", "ProductServiceImpl.java", "OfficeServiceImpl.java", 
        "EmployeeServiceImpl.java", "CustomerServiceImpl.java", "PaymentServiceImpl.java", 
        "OrderServiceImpl.java", "OrderDetailServiceImpl.java"
    ],
    "controller": [
        "ProductLineController.java", "ProductController.java", "OfficeController.java", 
        "EmployeeController.java", "CustomerController.java", "PaymentController.java", 
        "OrderController.java", "OrderDetailController.java"
    ]
}

# Package import strings for different layers
package_base = "package com.classicmodels.classicmodelsservice"
package_strings = {
    "entity": f"{package_base}.entity;\n\nimport lombok.Data;",
    "repository": f"{package_base}.repository;\n\nimport org.springframework.data.jpa.repository.JpaRepository;",
    "service": f"{package_base}.service;",
    "serviceImpl": f"{package_base}.service;",
    "controller": f"{package_base}.controller;\n\nimport org.springframework.web.bind.annotation.*;"
}

# Method to create directories and files with basic content
def create_structure(base, structure):
    for folder, files in structure.items():
        # Construct the full path
        folder_path = os.path.join(base, folder)
        os.makedirs(folder_path, exist_ok=True)

        if isinstance(files, str):  # Single main application file
            create_file(folder_path, files, "application")
        elif isinstance(files, list):  # List of files in each package
            for filename in files:
                create_file(folder_path, filename, folder)

def create_file(path, filename, file_type):
    file_path = os.path.join(path, filename)
    with open(file_path, "w") as f:
        if file_type == "application":
            f.write("package com.classicmodels.classicmodelsservice;\n\n" +
                     "import org.springframework.boot.SpringApplication;\n" +
                     "import org.springframework.boot.autoconfigure.SpringBootApplication;\n\n" +
                     "@SpringBootApplication\n" +
                     "public class ClassicModelsApplication {\n" +
                     "    public static void main(String[] args) {\n" +
                     "        SpringApplication.run(ClassicModelsApplication.class, args);\n" +
                     "    }\n}")
        else:
            # Write package declaration based on file type
            f.write(package_strings.get(file_type, "") + "\n\n")

            # Write class/interface declaration based on file type
            class_name = filename.replace(".java", "")
            if file_type == "repository":
                f.write(generate_repository_code(class_name))
            elif file_type == "serviceImpl":
                interface_name = class_name.replace("Impl", "")  # Get the base service name
                f.write(generate_service_impl_code(class_name, interface_name))
            elif "Service" in filename:
                f.write(generate_service_code(class_name))
            elif file_type == "controller":
                f.write(generate_controller_code(class_name))
            elif file_type == "entity":
                f.write(generate_entity_code(class_name))

def generate_entity_code(class_name):
    fields = {
        "ProductLine": [
            ("String", "productLine", "NOT NULL"),
            ("String", "textDescription", "DEFAULT NULL"),
            ("String", "htmlDescription", "DEFAULT NULL"),
            ("byte[]", "image", "DEFAULT NULL")
        ],
        "Product": [
            ("String", "productCode", "NOT NULL"),
            ("String", "productName", "NOT NULL"),
            ("String", "productLine", "NOT NULL"),
            ("String", "productScale", "NOT NULL"),
            ("String", "productVendor", "NOT NULL"),
            ("String", "productDescription", "NOT NULL"),
            ("short", "quantityInStock", "NOT NULL"),
            ("double", "buyPrice", "NOT NULL"),
            ("double", "MSRP", "NOT NULL")
        ],
        "Office": [
            ("String", "officeCode", "NOT NULL"),
            ("String", "city", "NOT NULL"),
            ("String", "phone", "NOT NULL"),
            ("String", "addressLine1", "NOT NULL"),
            ("String", "addressLine2", "DEFAULT NULL"),
            ("String", "state", "DEFAULT NULL"),
            ("String", "country", "NOT NULL"),
            ("String", "postalCode", "NOT NULL"),
            ("String", "territory", "NOT NULL"),
        ],
        "Employee": [
            ("int", "employeeNumber", "NOT NULL"),
            ("String", "lastName", "NOT NULL"),
            ("String", "firstName", "NOT NULL"),
            ("String", "extension", "NOT NULL"),
            ("String", "email", "NOT NULL"),
            ("String", "officeCode", "NOT NULL"),
            ("Integer", "reportsTo", "DEFAULT NULL"),
            ("String", "jobTitle", "NOT NULL"),
        ],
        "Customer": [
            ("int", "customerNumber", "NOT NULL"),
            ("String", "customerName", "NOT NULL"),
            ("String", "contactLastName", "NOT NULL"),
            ("String", "contactFirstName", "NOT NULL"),
            ("String", "phone", "NOT NULL"),
            ("String", "addressLine1", "NOT NULL"),
            ("String", "addressLine2", "DEFAULT NULL"),
            ("String", "city", "NOT NULL"),
            ("String", "state", "DEFAULT NULL"),
            ("String", "postalCode", "DEFAULT NULL"),
            ("String", "country", "NOT NULL"),
            ("Integer", "salesRepEmployeeNumber", "DEFAULT NULL"),
            ("double", "creditLimit", "DEFAULT NULL"),
        ],
        "Payment": [
            ("int", "customerNumber", "NOT NULL"),
            ("String", "checkNumber", "NOT NULL"),
            ("java.util.Date", "paymentDate", "NOT NULL"),
            ("double", "amount", "NOT NULL"),
        ],
        "Order": [
            ("int", "orderNumber", "NOT NULL"),
            ("java.util.Date", "orderDate", "NOT NULL"),
            ("java.util.Date", "requiredDate", "NOT NULL"),
            ("java.util.Date", "shippedDate", "DEFAULT NULL"),
            ("String", "status", "NOT NULL"),
            ("String", "comments", "DEFAULT NULL"),
            ("int", "customerNumber", "NOT NULL"),
        ],
        "OrderDetail": [
            ("OrderDetailPK", "id", "NOT NULL"),  # Composite Key
            ("int", "quantityOrdered", "NOT NULL"),
            ("double", "priceEach", "NOT NULL"),
            ("int", "orderLineNumber", "NOT NULL"),
        ],
        "OrderDetailPK": [
            ("int", "orderNumber", "NOT NULL"),
            ("String", "productCode", "NOT NULL")
        ]
    }
    
    fields_code = "\n".join(
        [f"    @Column(name = \"{field[1]}\", nullable = {str(field[2] == 'NOT NULL').lower()})\n    private {field[0]} {field[1]};"
         for field in fields[class_name]]
    )

    
    code = f"""package com.classicmodels.classicmodelsservice.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "{class_name.lower()}s")
public class {class_name} {{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Primary Key

{fields_code}

    // Getters and Setters are automatically generated by Lombok's @Data annotation
}}"""
    return code

def generate_repository_code(class_name):
    # Correcting the naming issue in the repository name
    simple_name = class_name.replace("Repository", "")
    code = f"""package com.classicmodels.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.classicmodels.classicmodelsservice.entity.{simple_name};

public interface {simple_name}Repository extends JpaRepository<{simple_name}, Integer> {{
}}"""
    return code

def generate_service_code(class_name):
    # Creating the service interface without duplication in the name
    simple_name = class_name.replace("Service", "")
    code = f"""package com.classicmodels.classicmodelsservice.service;

import java.util.List;
import com.classicmodels.classicmodelsservice.entity.{simple_name};

public interface {simple_name}Service {{
    List<{simple_name}> findAll();
    {simple_name} findById(int id);
    {simple_name} save({simple_name} {simple_name.lower()});
    void deleteById(int id);
}}"""
    return code

def generate_service_impl_code(class_name, interface_name):
    # Determine base name to avoid 'Service' redundancy and correct repository variable
    simple_name = interface_name.replace("Service", "")
    repository_name = f"{simple_name.lower()}Repository"

    code = f"""package com.classicmodels.classicmodelsservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.classicmodels.classicmodelsservice.entity.{simple_name};
import com.classicmodels.classicmodelsservice.repository.{simple_name}Repository;

@Service
public class {class_name} implements {interface_name} {{

    @Autowired
    private {simple_name}Repository {repository_name};  // Corrected repository variable

    @Override
    public List<{simple_name}> findAll() {{
        return {repository_name}.findAll();
    }}

    @Override
    public {simple_name} findById(int id) {{
        return {repository_name}.findById(id).orElse(null);
    }}

    @Override
    public {simple_name} save({simple_name} {simple_name.lower()}) {{
        return {repository_name}.save({simple_name.lower()});
    }}

    @Override
    public void deleteById(int id) {{
        {repository_name}.deleteById(id);
    }}
}}"""
    return code


def generate_controller_code(class_name):
    base_class_name = class_name.replace("Controller", "")
    code = f"""package com.classicmodels.classicmodelsservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.classicmodels.classicmodelsservice.entity.{base_class_name};
import com.classicmodels.classicmodelsservice.service.{base_class_name}Service;

@RestController
@RequestMapping("/api/{base_class_name.lower()}s")
public class {class_name} {{

    @Autowired
    private {base_class_name}Service service;

    @GetMapping
    public List<{base_class_name}> findAll() {{
        return service.findAll();
    }}

    @GetMapping("/{id}")
    public {base_class_name} findById(@PathVariable int id) {{
        return service.findById(id);
    }}

    @PostMapping
    public {base_class_name} save(@RequestBody {base_class_name} {base_class_name.lower()}) {{
        return service.save({base_class_name.lower()});
    }}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {{
        service.deleteById(id);
    }}
}}"""
    return code

# Create the directory structure and files
create_structure(base_dir, structure)
