#  Amarradero Llanero - Spring Boot

This repository combines Camunda (business process automation platform) with a Spring Boot application and a PostgreSQL database for the "Amarradero Llanero" restaurant, all supported by Amazon Web Services (AWS) services such as RDS and EC2 for the database instance and for running the program in a virtual machine, respectively. 

***The program has two ways to run, locally or in the cloud.***

## Index

1. [Description](#description)
2. [Usage](#usage)
3. [Funcionality](#funcionality)

## Description

The integration of Camunda and Spring Boot plays a key role in improving the automation and efficiency of business processes. The Amarradero Llanero project is designed using **Docker** containers to ensure both portability and scalability of the application. Leveraging a **PostgreSQL database** from the **AWS service**, the project efficiently stores relevant data while orchestrating processes and tasks through Camunda to streamline activities.

Focused on creating a restaurant order management system, the project leverages Spring Boot's project initializer that integrates the Camunda engine (https://start.camunda.com/). This application allows users to register, place orders to the various sections of the restaurant and seamlessly automates workflow processes. In particular, all user and order information is securely stored in the PostgreSQL database hosted on the AWS service.

The database store the following attributes for each instance of BPM model:<br><br>
**Table Users**
| Id     | Username        | Fullname       | Email           | Password     |
| ------------- | --------------------|-----------------------|--------------------|--------------- |
|Unique identifier| User's username | Full name | Email address | Password |

**Table Orders**
| Id     | CurrentDate        | PedidoAsadero       | CantPedidoAsadero           | PedidoCocina     | CantPedidoCocina | pedidoBar| cantPedidoBar |
| ------------- | ---------|-----------|-----------|------------|------------|--------|--------------- |
|Unique identifier for each record.| The date when the order was placed. | The order from the grill section. | The quantity of the grill order. | The order from the kitchen section. | The quantity of the kitchen order. |  The order from the bar section.  |  The quantity of the bar order. |

## Usage
Before running the program, make sure of the following **(the easiest is with AWS)**:

***if you want to run it locally:***

1. **Code editor**: If you want to modify AmarraderoLlanero, we recommend you to use Visual Studio Code (VS Code). You can download it from the [official website].(https://code.visualstudio.com/download).

2. **Version control system**: Install GIT from the [official website](https://git-scm.com/downloads).

3. **Docker Desktop**: To use Docker correctly follow the steps below:
    - **Step 1**: Install Docker from the [official website](https://www.docker.com/products/docker-desktop/).*(If you already have Docker Desktop installed, skip this step).*
    - **Step 2**: Create a Docker Hub account from the [official website](https://hub.docker.com/signup), and log in to Docker Desktop.
    *(If you already have an account, log in directly to Docker Desktop)*

5. **WSL2**: According to your need:
    - Use the following command to install WSL2
    `wsl --list --o` to know the available distributions.
    `wsl --install -d "distribution-version"` to install WSL2 with a specific distribution.
    - Use the following command for upgrade to WSL2
    `wsl --version` if you want to know the installed WSL version
    `wsl --set-default-version 2` to change the version to WSL2.

6. **PgAdmin**: [official website](https://www.postgresql.org/download/) to install PostgreSQL and pgAdmin for the database manage.

7. Create a database called amarraderollanero with the help of pgAdmin and modify in src/main/resources/application.properties the following: 

    ````configuration
    spring.datasource.url=jdbc:postgresql://localhost/amarraderollanero
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ````

8. **Clone the repository**: Use the following command to clone the repository: `git clone https://github.com/BPMN-sw-evol/AmarraderoLlanero-SB`.

9. Inside the previously cloned repository, in a terminal run the following command to create the image from the Dockerfile: `docker build -t amarraderolocal .`.

10. Now run the following command to run the docker container: `docker run -p 8080:8080 amarraderolocal`.

11. Ready! Use the program.

***if you want to run it in the cloud:***

***IMPORTANT NOTE:*** in this [link](https://docs.google.com/document/d/1DGI8_nkBq9eD0TAqSlSBcFuYAjRvll_k/edit?usp=sharing&ouid=116840209235218873766&rtpof=true&sd=true) there is a STEP BY STEP guide on how to create and configure the AWS EC2 and RDS services for this project to run quickly and easily.

1. Sign up for Amazon Web Service. [official website](https://portal.aws.amazon.com/billing/signup#/start/email) (if you are already registered, skip this step.).

2. Log in to the AWS Management Console using your credentials.: [official website](https://aws.amazon.com/marketplace/management/signin) (if you are already registered, skip this step.).

3. Navigate to the Services section or use the search bar to find the EC2 (Elastic Compute Cloud - Virtual Cloud Servers) service and create an EC2 service with its respective configuration.

4. Now do the same as in the previous step, but to create the database instance in the RDS service. 

5. On EC2 update the system with the package manager. 

6. Install GIT on EC2

7. Install Docker on EC2

7. Clone this repository on EC2 with `git clone https://github.com/BPMN-sw-evol/AmarraderoLlanero-SB` 

9. Inside the previously cloned repository run the following command to create the image from the Dockerfile: `docker build -t amarraderoaws .`.

10. Now run the following command to run the docker container: `docker run -p 8080:8080 amarraderoaws`.

11. Ready! Use the program.

## Funcionality

