# Setting Up WSL (Windows Subsystem for Linux)
- [Introduction](#introduction)
- [Benefits of WSL](#benefits-of-wsl)
- [Installation](#installation)
- [Step-by-step guide to install WSL and a Linux distribution on Windows](#step-by-step-guide-to-install-wsl-and-a-linux-distribution-on-windows)
- [Usage](#usage)
- [Example Commands](#example-commands)
- [Interacting with Files](#interacting-with-files)
- [Integration](#integration)
- [Accessing Windows Files](#accessing-windows-files)
- [Networking](#networking)
- [Key Features](#key-features)
- [Use Cases](#use-cases)
- [Differences of WSL1 and WSL2](#differences-of-wsl1-and-wsl2)
- [How to install WSL2 + UBUNTU](#how-to-install-wsl2--ubuntu)
- [How to configure WSL2 + UBUNTU](#how-to-configure-wsl2--ubuntu)
- [Step 1: Update and Upgrade Ubuntu](#step-1-update-and-upgrade-ubuntu)
- [Step 2: Create .wslconfig file in your home directory](#step-2-create-wslconfig-file-in-your-home-directory)
- [Step 3: Create the file with the following content](#step-3-create-the-file-with-the-following-content)


## Introduction

Windows Subsystem for Linux (WSL) is a compatibility layer for running Linux binary executables natively on Windows 10 and Windows Server 2019. It allows developers and users to run a Linux environment directly on Windows without the need for a virtual machine or dual-boot setup.

### Benefits of WSL:
- Seamless integration of Linux tools and workflows with Windows.
- Access to a wide range of Linux applications and development tools.
- Improved performance compared to traditional virtualization methods.
- Simplified development environment setup for cross-platform development.

## Installation

### Step-by-step guide to install WSL and a Linux distribution on Windows:
1. Enable WSL feature in Windows:
    - Open PowerShell as Administrator.
    - Run the command: `wsl --install` to enable WSL and install the necessary components.

2. Choose and install a Linux distribution from the Microsoft Store:
    - Open Microsoft Store from the Start menu.
    - Search for your preferred Linux distribution (e.g., Ubuntu, Debian, or Fedora).
    - Click on the distribution, then click "Install" to download and install it.

3. Initialize your Linux distribution:
    - Launch the installed Linux distribution from the Start menu or command prompt.
    - Follow the on-screen instructions to set up a new Linux user account and password.

## Usage

Once WSL and a Linux distribution are installed, you can start using Linux commands and tools directly within the Windows environment.

### Example Commands:
- `ls` - List files and directories.
- `cd` - Change directory.
- `mkdir` - Create a new directory.
- `grep` - Search for patterns in files.
- `apt` or `apt-get` - Package management for installing software.
- `ssh` - Securely connect to remote servers.
- `git` - Version control system for tracking changes in code.
- `docker` - Platform for building, sharing, and running containerized applications.
- `java` - Run Java applications and programs.
- `mvn` - Build and manage Java projects using Maven.
- `pwd` - Print the current working directory.
- `cat` - Display the contents of a file.
- `nano` - A simple text editor for creating and editing files.
- `rm` - Remove files and directories.
- `cp` - Copy files and directories.
- `mv` - Move or rename files and directories.
- `chmod` - Change file permissions.
- `chown` - Change file ownership.
- `tar` - Create and extract tar archives.
- `curl` - Transfer data from or to a server.
- `wget` - Download files from the internet.
- `ping` - Test network connectivity to a remote host.
- `traceroute` - Display the route and measure transit delays of packets across an IP network.
- `netstat` - Display network connections, routing tables, interface statistics, masquerade connections, and multicast memberships.
- `ifconfig` - Configure network interfaces.
- `route` - Show / manipulate the IP routing table.
- `hostname` - Print or set the system`s host name.
- `uname` - Print system information.
- `ps` - Report a snapshot of the current processes.
- `top` - Display Linux processes.
- `kill` - Send a signal to a process.
- `shutdown` - Shutdown or restart the system.
- `reboot` - Reboot the system.
- `df` - Report file system disk space usage.
- `du` - Estimate file space usage.
- `free` - Display amount of free and used memory in the system.
- `grep` - Print lines matching a pattern.
- `find` - Search for files in a directory hierarchy.
- `sed` - Stream editor for filtering and transforming text.
- `awk` - Pattern scanning and processing language.
- `sort` - Sort lines of text files.
- `uniq` - Report or omit repeated lines.
- `wc` - Print newline, word, and byte counts for each file.


### Interacting with Files:
- Linux files are stored within the Windows file system under the path `\\wsl$`.
- You can access and manipulate Windows files from within the Linux environment and vice versa.

## Integration

WSL seamlessly integrates with the Windows file system, allowing easy access to Windows files and directories from the Linux environment. Similarly, WSL integrates with Windows networking, enabling network connectivity and communication between Linux and Windows applications.

### Accessing Windows Files:
- Windows files can be accessed from within the Linux environment at the path `/mnt/<drive letter>/`.
- For example, Windows C: drive can be accessed in Linux at `/mnt/c/`.

## Networking
Windows Subsystem for Linux (WSL) provides a powerful environment for running Linux applications on a Windows machine. One of the key features of WSL is its seamless integration with Windows networking, allowing for consistent and efficient network configurations and operations across both platforms.

- WSL shares network configurations with Windows, allowing Linux applications to access network resources and services available to Windows.
- Networking commands and configurations in Linux work similarly to their counterparts in Windows, ensuring consistency across both environments.

WSL bridges the gap between Windows and Linux networking, offering a unified and efficient environment for managing network configurations and operations. Its integration with Windows networking ensures a seamless experience for users who work across both platforms.

### Key Features

- **Shared Network Configurations:** WSL shares network configurations with the Windows host, enabling Linux applications to access the same network resources and services that are available to Windows.

- **Consistent Networking Commands:** Networking commands in Linux, such as `ifconfig`, `ping`, and `ssh`, work similarly to their counterparts in Windows. This consistency ensures a smooth transition for users who are familiar with Windows networking commands.

- **Access to Windows Services:** Linux applications running in WSL can access network services running on the Windows host, such as databases, web servers, and file shares.

- **Integration with Windows Firewall:** WSL respects the Windows Firewall settings, ensuring that network security policies are applied uniformly across both environments.

### Use Cases

- **Development and Testing:** WSL is an ideal environment for developing and testing cross-platform applications that need to run on both Windows and Linux.

- **Network Administration:** System administrators can use WSL to manage network configurations, troubleshoot network issues, and run network diagnostics tools on a Windows machine.

- **Educational Purposes:** WSL provides a convenient platform for learning Linux networking concepts and commands without the need for a separate Linux machine.

### Differences of WSL1 and WSL2

| Feature         | WSL 1                                 | WSL 2                               |
|-----------------|---------------------------------------|-------------------------------------|
| Kernel          | Uses Windows NT kernel               | Uses a real Linux kernel in a VM    |
| Performance     | Less performance                      | Better performance                  |
| Compatibility   | Good compatibility with Linux apps    | Improved compatibility with Linux apps |
| Resource Usage  | Lightweight                           | Requires more resources             |
| Windows Features| Limited access to Windows features    | May have compatibility issues with some Windows features |


## How to install WSL2 + UBUNTU
- Run PowerShell with elevated privileges

![WSL-01.jpg](resources%2FWSL-01.jpg)

And run step by step commands bellow:

```bash
    dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart 
		
    dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
```
		
Now you need to restart your PC in order to apply  VirtualMachinePlatform


After restart Run PowerShell with elevated privileges and run
```bash
	> wsl --update
	> wsl --set-default-version 2
	> wsl --install -d Ubuntu-20.04
```

Open Microsoft store, search Terminal and install it

![WSL-02.jpg](resources%2FWSL-02.jpg)

![WSL-03.jpg](resources%2FWSL-03.jpg)

After installation, open Terminal and run the following command to check the version of WSL
```bash
    wsl -l -v
```

Open windows terminal and select Ubuntu (or Ubuntu 20.04) from the dropdown list

![WSL-04.jpg](resources%2FWSL-04.jpg)

## How to configure WSL2 + UBUNTU

### Step 1: Update and Upgrade Ubuntu
```bash
    sudo apt update
    sudo apt upgrade
```

### Step 2: Create .wslconfig file in your home directory C:\Users\\{YourUsername}
```bash
    nano ~/.wslconfig
```
### Step 3: Create the file with the following content:
```bash
    [wsl2]
    memory=4GB
    processors=2
    swap=1GB
    kernelCommandLine=systemd.unified_cgroup_hierarchy=1 cgroup_no_v1=all
```
- `memory=4GB`: This option sets the maximum amount of memory that can be allocated to the Linux virtual machine in WSL 2. In this case, the limit is set to 4 gigabytes. If you want to allocate more memory, you can change this value.

- `processors=2`: This option determines the number of processor cores that will be available to the Linux virtual machine. In this example, the virtual machine is allocated two processor cores.

- `swap=1GB`: This option sets the size of the swap file for the Linux virtual machine. The swap file is used for temporarily storing data from memory when it is full. In this case, the size of the swap file is set to 1 gigabyte.

- `kernelCommandLine` option in the WSL 2 configuration allows you to specify additional command-line parameters for the Linux kernel. This option is particularly useful for fine-tuning the behavior of the virtual machine and ensuring compatibility with specific requirements. The line in the configuration file is as follows:
```java
   kernelCommandLine=systemd.unified_cgroup_hierarchy=1 cgroup_no_v1=all
```

This line consists of two parts:

- `systemd.unified_cgroup_hierarchy=1`: This parameter enables the use of a unified control group (cgroup) hierarchy version 2 in the system. This allows for more efficient resource management and isolation of processes in containers.

- `cgroup_no_v1=all`: This parameter disables the use of the old version of control groups (cgroups v1) for all subsystems. This ensures a more modern and secure resource management system.

Together, these settings help optimize the performance and behavior of the Linux virtual machine in WSL 2. They also ensure compatibility with specific requirements, such as the use of systemd and the new version of cgroups.
