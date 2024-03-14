- [How to Create a Free AWS Account](#how-to-create-a-free-aws-account)
   - [Step 1: Sign Up for an AWS Account](#step-1-sign-up-for-an-aws-account)
   - [Step 2: Contact Information](#step-2-contact-information)
   - [Step 3: Payment Information](#step-3-payment-information)
   - [Step 4: Identity Verification](#step-4-identity-verification)
   - [Step 5: Choose a Support Plan](#step-5-choose-a-support-plan)
   - [Step 6: Access the AWS Management Console](#step-6-access-the-aws-management-console)
   - [Important Notes](#important-notes)
- [Creating a Free AWS Remote Host](#creating-a-free-aws-remote-host)
   - [Step 1: Sign Up for an AWS Account](#step-1-sign-up-for-an-aws-account-1)
   - [Step 2: Launch an EC2 Instance](#step-2-launch-an-ec2-instance)
   - [Step 3: Connect to Your Instance](#step-3-connect-to-your-instance)
   - [Step 4: Use Your Instance](#step-4-use-your-instance)
   - [Important Notes](#important-notes-1)
- [How to connect to your AWS EC2 instance using PuTTY](#to-connect-to-your-aws-ec2-instance-using-putty)
   - [Step 1: Convert Your Private Key](#step-1-convert-your-private-key)
   - [Step 2: Configure PuTTY](#step-2-configure-putty)


# How to Create a Free AWS Account

You can practice with real Linux servers by creating a free AWS account and launching an EC2 instance. This will allow you to use a remote host for educational purposes, and gain hands-on experience with AWS services.
Amazon Web Services (AWS) offers a Free Tier for new customers, which allows you to explore and try out AWS services for free, up to certain usage limits. Here are the steps to create a free AWS account:

## Step 1: Sign Up for an AWS Account

1. Go to the AWS Free Tier page: [AWS Free Tier](https://aws.amazon.com/free/)
2. Click on the **Create a Free Account** button.
3. Fill in your email address, password, and account name in the sign-up form.
4. Click **Continue** to proceed to the next step.
   ![AWS-01.jpg](resources%2FAWS-01.jpg)
## Step 2: Contact Information

1. Choose **Personal** or **Professional** account type. For personal use, select **Personal**.
2. Fill in your personal information, including your full name, phone number, and address.
3. Read and accept the AWS Customer Agreement.
4. Click **Create Account and Continue**.
   ![AWS-02.jpg](resources%2FAWS-02.jpg)
## Step 3: Payment Information

1. Enter your credit card information. Although AWS Free Tier is free, a credit card is required to cover any charges if you exceed the free tier limits.
2. Click **Secure Submit**.

## Step 4: Identity Verification

1. AWS will verify your identity by sending a code via a phone call or SMS.
2. Enter the code you received to complete the verification process.

## Step 5: Choose a Support Plan

1. Select the **Basic Plan** for the free tier of support.
2. Click **Complete Sign Up**.

## Step 6: Access the AWS Management Console

1. Once your account is activated, you can sign in to the AWS Management Console.
2. Explore the available services and start using AWS within the Free Tier limits.

## Important Notes

- The AWS Free Tier is available for 12 months after account creation.
- Different services have different limits under the Free Tier. Make sure to check the specific limits for each service you use.
- Keep an eye on your usage to avoid any unexpected charges.

For more detailed information, visit the [AWS Free Tier](https://aws.amazon.com/free/) page.

# Creating a Free AWS Remote Host

Amazon Web Services (AWS) offers a Free Tier that allows you to create and use a remote host (virtual machine) for free, within certain usage limits. This can be particularly useful for educational purposes. Follow these steps to set up a free AWS remote host:

## Step 1: Sign Up for an AWS Account

If you haven't already, sign up for an AWS account by following the instructions in [How to Create a Free AWS Account](#how-to-create-a-free-aws-account).
![AWS-03.jpg](resources%2FAWS-03.jpg)
## Step 2: Launch an EC2 Instance

1. Sign in to the AWS Management Console.
2. Navigate to the EC2 dashboard.
3. Click on **Launch Instance** to create a new virtual machine.
4. Choose an **Amazon Machine Image (AMI)**. For free tier usage, select an AMI that is eligible for the free tier, such as Amazon Linux 2 or Ubuntu Server.
5. Choose an **Instance Type**. Select the `t2.micro` instance type, which is eligible for the free tier.
6. Click **Next: Configure Instance Details** and set up the instance as needed.
7. Click **Next: Add Storage**. The default storage options are usually sufficient for educational purposes.
8. Click **Next: Add Tags** if you want to add tags to your instance; otherwise, proceed to the next step.
9. Click **Next: Configure Security Group**. Create a new security group or select an existing one. Ensure that you allow SSH access (port 22) so that you can connect to the instance remotely.
10. Click **Review and Launch**.
11. Review your instance configuration and click **Launch**.
12. When prompted, select an existing key pair or create a new key pair. This key pair will be used to securely connect to your instance via SSH. Download the key pair and keep it safe.

## Step 3: Connect to Your Instance

1. Once your instance is running, select it in the EC2 dashboard and click **Connect**.
   ![AWS-04.jpg](resources%2FAWS-04.jpg)
2. Follow the instructions provided to connect to your instance using SSH. You will need the key pair you downloaded earlier.

## Step 4: Use Your Instance

Your AWS remote host is now set up and ready to use for educational purposes. You can install software, run applications, and perform other tasks on your instance.
![AWS-05.jpg](resources%2FAWS-05.jpg)
## Important Notes

- The `t2.micro` instance type is covered under the AWS Free Tier for the first 12 months after account creation, with some usage limits.
- Be sure to monitor your usage to avoid any charges if you exceed the Free Tier limits.
- Remember to stop or terminate your instance when you're not using it to avoid unnecessary charges.

For more detailed information, visit the [AWS EC2 Documentation](https://docs.aws.amazon.com/ec2/index.html).

## To connect to your AWS EC2 instance using PuTTY
you'll need to convert your private key file (.pem file) to a PuTTY-compatible format (.ppk file) and then configure PuTTY with the appropriate settings. Here's how to do it:

### Step 1: Convert Your Private Key
- **Download PuTTYgen:** If you haven't already, download and install PuTTYgen from the PuTTY download page.
- **Open PuTTYgen:** Launch PuTTYgen to convert your private key.
- **Load Your Private Key:**
   - Click the **Load** button.
   - Navigate to the location of your .pem file.
   - By default, PuTTYgen only shows files with a .ppk extension. To see your .pem file, select "All Files (\*.\*)" from the dropdown menu.
   - Select your .pem file and click **Open**.
- **Save Your Private Key:**
   - Click the **Save private key** button.
   - Choose a location and filename for your .ppk file (e.g., mykey.ppk).
   - Click **Save**.

### Step 2: Configure PuTTY
- **Open PuTTY:** Launch the PuTTY SSH client.
- **Enter Hostname or IP Address:**
   - In the **Host Name (or IP address)** field, enter the public IP address of your EC2 instance. You can find this in the AWS Management Console under the EC2 dashboard.
- **Configure the Connection:**
  ![AWS-06.jpg](resources%2FAWS-06.jpg)
   - In the Category pane on the left, navigate to **Connection > SSH > Auth**.
   - Click the **Browse** button next to **Private key file for authentication**.
   - Select the .ppk file you created earlier and click **Open**.
     ![AWS-07.jpg](resources%2FAWS-07.jpg)
- **(Optional) Save Your Session:**
   - In the Category pane, return to the **Session** category.
   - Enter a name for the session in the **Saved Sessions** field.
   - Click the **Save** button to save the session settings for future use.
- **Connect:**
   - Click the **Open** button to initiate the connection.
   - If prompted, accept the server's host key by clicking **Yes**.
   - When prompted for a username, enter `ubuntu`.

You should now be connected to your AWS EC2 instance via PuTTY.
![AWS-08.jpg](resources%2FAWS-08.jpg)

Copyright © 2024 by Iurii Rusakov