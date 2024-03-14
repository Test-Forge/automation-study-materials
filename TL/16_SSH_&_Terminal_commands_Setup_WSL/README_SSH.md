# Secure Shell (SSH)

- [Secure Shell (SSH)](#secure-shell-ssh)
   - [Versions of SSH](#versions-of-ssh)
      - [Differences Between SSH-1 and SSH-2](#differences-between-ssh-1-and-ssh-2)
   - [Creating a Pair of SSH Keys](#creating-a-pair-of-ssh-keys)
   - [Example Output](#example-output)
   - [Usage of SSH Keys](#usage-of-ssh-keys)

Secure Shell (SSH) is a cryptographic network protocol used for a secure connection between a client and a server. It allows for secure data communication, remote command execution, and other secure network services between two networked computers.

## Versions of SSH

There are two major versions of SSH:

- **SSH-1:** The original version that has now been largely deprecated due to inherent security vulnerabilities, such as security flaws in its protocol.
- **SSH-2:** An improved version that fixed the vulnerabilities of SSH-1 and introduced more advanced features like enhanced security and the ability to run multiple sessions over a single SSH connection.

### Differences Between SSH-1 and SSH-2

| Feature              | SSH-1                           | SSH-2                                       |
|----------------------|---------------------------------|---------------------------------------------|
| Security             | Basic, with known vulnerabilities| Enhanced, with more robust encryption       |
| Protocol Architecture| Monolithic                      | Modular                                     |
| Port Forwarding      | Supports only X11 forwarding    | Supports local, remote, and dynamic forwarding|
| Authentication Methods| RSA based                       | Supports RSA, DSA, ECDSA, and more         |
| Session Channels     | Single session per connection   | Multiple sessions over a single connection |

## Creating a Pair of SSH Keys

To create a new SSH key pair:

1. Open a terminal.
2. Run the following command:

```bash
ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```
- `t rsa`: Specifies the type of key to create, in this case, RSA.
- `b 4096`: Specifies the number of bits in the key, in this case, 4096 bits for added security.
- `C`: A label or comment to add to the key, usually your email.

When prompted to "Enter a file in which to save the key," press Enter to save in the default location.
At the prompt, type a secure passphrase or press Enter to proceed without one.

## Example Output:

```bash
Generating public/private rsa key pair.
Enter file in which to save the key (/your/home/directory/.ssh/id_rsa):
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /your/home/directory/.ssh/id_rsa.
Your public key has been saved in /your/home/directory/.ssh/id_rsa.pub.
```
## Usage of SSH Keys
SSH can be used for various purposes, including but not limited to:

- **Remote Login:** Log into another computer over a network to execute commands.
- **Secure File Transfer:** Use SCP or SFTP to securely transfer files between a client and a server.
- **Port Forwarding:** Securely forward traffic through an encrypted SSH tunnel.
- **SSH Key Management:** Manage and use SSH keys for authentication without the need for passwords.

To connect to a server using SSH:
```bash
ssh username@remote_host
```
Where username is your username on the remote_host server you wish to connect to.

Copyright © 2024 by Iurii Rusakov

