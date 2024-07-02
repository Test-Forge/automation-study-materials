# Java Input/Output (I/O) Programming

[1. Introduction](#1-introduction)

[2. Java NIO Package](#2-java-nio-package)

[2.1. Channel](#21-channel)

[2.2. Buffer](#22-buffer)

[2.3. Selector](#23-selector)

[2.4. Shortcomings of NIO Package](#24-shortcomings-of-nio-package)

[3. Java NIO.2 Package](#3-java-nio2-package)

[4. Example of NIO and NIO.2 Usage](#4-example-of-nio-and-nio2-usage)

[4.1. I/O from the Command Line](#41-io-from-the-command-line)

[4.2. Standard Streams](#42-standard-streams)

[4.3. Random Access Files](#43-random-access-files)

[4.4. Creating and Reading Directories](#44-creating-and-reading-directories)

[4.5. Listing a File System's Root Directories](#45-listing-a-file-systems-root-directories)

[4.6. Creating a Directory](#46-creating-a-directory)

[5. Comparison of Java IO, Java NIO, and Java NIO2](#5-comparison-of-java-io-java-nio-and-java-nio2)

[6. File Transfer Performance Analysis](project/server-io/README.md#file-transfer-performance-analysis)

[6.1. How It Works](project/server-io/README.md#how-it-works)

[6.2. Running the Code](project/server-io/README.md#running-the-code)

[6.3. Running the Code in IntelliJ IDEA](project/server-io/README.md#running-the-code-in-intellij-idea)

[6.4. Customizing the File Size](project/server-io/README.md#customizing-the-file-size)

[6.5. Running the Code in CLI](project/server-io/README.md#running-the-code-in-cli)

[6.6. Locally](project/server-io/README.md#locally)

[6.7. Client-Server Setup in a Local Network](project/server-io/README.md#client-server-setup-in-a-local-network)

[6.8. Results](project/server-io/README.md#results)

[6.9. Project Structure](project/server-io/README.md#project-structure)

## 1. Introduction
In this file, we’ll cover Java IO functionalities and how they changed throughout different Java versions. First, we’ll cover the `java.io` package from the initial Java version. Next, we’ll go over `java.nio` package introduced in Java 1.4. In the end, we’ll cover the `java.nio.file` package, commonly known as the NIO.2 package.

## 2. Java NIO Package

The first Java version was released with the `java.io` package, introducing a `File` class to access the file system. The `File` class represents files and directories and provides limited operations on the file system. It was possible to create and delete files, check if they exist, check read/write access, etc.

It also has some shortcomings:

- Lack of copy method – to copy a file, we need to create two `File` instances and use a buffer to read from one and write to another `File` instance.
- Bad error handling – some methods return boolean as an indicator if an operation is successful or not.
- A limited set of file attributes – name, path, read/write privileges, memory size is available, to name a few.
- Blocking API – our thread is blocked until the IO operation is complete.

To read a file, we need a `FileInputStream` instance to read bytes from the file:

```java
@Test
public void readFromFileUsingFileIO() throws Exception {
    File file = new File("src/test/resources/nio-vs-nio2.txt");
    FileInputStream in = new FileInputStream(file);
    StringBuilder content = new StringBuilder();
    int data = in.read();
    while (data != -1) {
        content.append((char) data);
                data = in.read();
    }
    in.close();
    assertThat(content.toString()).isEqualTo("Hello from file!");
}
```

Next, Java 1.4 introduces non-blocking IO API bundled in `java.nio` package (nio stands for new IO). NIO was introduced to overcome the limitations of the `java.io` package. This package introduced three core classes: Channel, Buffer, and Selector.

### 2.1. Channel
Java NIO Channel is a class that allows us to read and write to a buffer. Channel class is similar to Streams (here we speak of IO Streams, not Java 1.8 Streams) with a couple of differences. Channel is a two-way street while Streams are usually one-way, and they can read and write asynchronously.

There are a couple of implementations of the Channel class, including `FileChannel` for file system read/write, `DatagramChannel` for read/write over a network using UDP, and `SocketChannel` for read/write over a network using TCP.

### 2.2. Buffer
Buffer is a block of memory from which we can read or write data into it. NIO Buffer object wraps a memory block. Buffer class provides a set of functionalities to work with the memory block. To work with Buffer objects, we need to understand three major properties of the Buffer class: capacity, position, and limit.

- Capacity defines the size of the memory block. When we write data to the buffer, we can write only a limited length. When the buffer is full, we need to read the data or clear it.
- The position is the starting point where we write our data. An empty buffer starts from 0 and goes to capacity – 1. Also, when we read the data, we start from the position value.
- Limit means how we can write and read from the buffer.

There are multiple variations of the Buffer class. One for each primitive Java type, excluding the Boolean type plus the `MappedByteBuffer`.

To work with a buffer, we need to know a few important methods:
- `allocate(int value)` – we use this method to create a buffer of a certain size.
- `flip()` – this method is used to switch from write to read mode.
- `clear()` – method for clearing the content of the buffer.
- `compact()` – method for clearing only the content we have already read.
- `rewind()` – resets position back to 0 so we can reread the data in the buffer.

Using previously described concepts, let’s use Channel and Buffer classes to read content from a file:

```java
@Test
public void readFromFileUsingFileChannel() throws Exception {
    RandomAccessFile file = new RandomAccessFile("src/test/resources/nio-vs-nio2.txt", "r");
    FileChannel channel = file.getChannel();
    StringBuilder content = new StringBuilder();
    ByteBuffer buffer = ByteBuffer.allocate(256);
    int bytesRead = channel.read(buffer);
    while (bytesRead != -1) {
        buffer.flip();
        while (buffer.hasRemaining()) {
            content.append((char) buffer.get());
        }
        buffer.clear();
                bytesRead = channel.read

                (buffer);
    }
    file.close();
    assertThat(content.toString()).isEqualTo("Hello from file!");
}
```

After initializing all required objects, we read from the channel into the buffer. Next, in the while loop, we mark the buffer for reading using the `flip()` method and read one byte at a time, and append it to our result. In the end, we clear the data and read another batch.

### 2.3. Selector
Java NIO Selector allows us to manage multiple channels with a single thread. To use a selector object to monitor multiple channels, each channel instance must be in the non-blocking mode, and we must register it. After channel registration, we get a `SelectionKey` object representing the connection between channel and selector. When we have multiple channels connected to a selector, we can use the `select()` method to check how many channels are ready for use. After calling the `select()` method, we can use `selectedKeys()` method to fetch all ready channels.

### 2.4. Shortcomings of NIO Package
The changes `java.nio` package introduced is more related to low-level data IO. While they allowed non-blocking API, other aspects remained problematic:

- Limited support for symbolic links.
- Limited support for file attributes access.
- Missing better file system management tools.

## 3. Java NIO.2 Package
Java 1.7 introduces new `java.nio.file` package, also known as NIO.2 package. This package follows an asynchronous approach to non-blocking IO not supported in `java.nio` package. The most significant changes are related to high-level file manipulation. They are added with `Files`, `Path`, and `Paths` classes. The most notable low-level change is the addition of `AsynchronousFileChannel` and `AsynchronousSocketChannel`.

`Path` object represents a hierarchical sequence of directories and file names separated by a delimiter. The root component is furthest to the left, while the file is right. This class provides utility methods such as `getFileName()`, `getParent()`, etc. The `Path` class also provides `resolve` and `relativize` methods that help construct paths between different files. `Paths` class is a set of static utility methods that receive String or URI to create `Path` instances.

`Files` class provides utility methods that use the previously described `Path` class and operate on files, directories, and symbolic links. It also provides a way to read many file attributes using `readAttributes()` method.

In the end, let’s see how NIO.2 compares to previous IO versions when it comes to reading a file:

```java
@Test
public void readFromFileUsingNIO2() throws Exception {
    List<String> strings = Files.readAllLines(Paths.get("src/test/resources/nio-vs-nio2.txt"));
    assertThat(strings.get(0)).isEqualTo("Hello from file!");
}
```

## 4. Example of NIO and NIO.2 Usage
### 4.1. I/O from the Command Line
A program is often run from the command line and interacts with the user in the command line environment. The Java platform supports this kind of interaction in two ways: through the Standard Streams and through the Console.

### 4.2. Standard Streams
Standard Streams are a feature of many operating systems. By default, they read input from the keyboard and write output to the display. They also support I/O on files and between programs, but that feature is controlled by the command line interpreter, not the program.

The Java platform supports three Standard Streams: Standard Input, accessed through System.in; Standard Output, accessed through System.out; and Standard Error, accessed through System.err. These objects are defined automatically and do not need to be opened. Standard Output and Standard Error are both for output; having error output separately allows the user to divert regular output to a file and still be able to read error messages. For more information, refer to the documentation for your command line interpreter.

You might expect the Standard Streams to be character streams, but, for historical reasons, they are byte streams. System.out and System.err are defined as PrintStream objects. Although it is technically a byte stream, PrintStream utilizes an internal character stream object to emulate many of the features of character streams.

By contrast, `System.in` is a byte stream with no character stream features. To use Standard Input as a character stream, wrap `System.in in` `InputStreamReader`.
    
```bash
InputStreamReader cin = new InputStreamReader(System.in);
```
### 4.3. Random Access Files
Random access files permit nonsequential, or random, access to a file's contents. To access a file randomly, you open the file, seek a particular location, and read from or write to that file.

This functionality is possible with the SeekableByteChannel interface. The SeekableByteChannel interface extends channel I/O with the notion of a current position. Methods enable you to set or query the position, and you can then read the data from, or write the data to, that location. The API consists of a few, easy to use, methods:

- position – Returns the channel's current position
- position(long) – Sets the channel's position
- read(ByteBuffer) – Reads bytes into the buffer from the channel
- write(ByteBuffer) – Writes bytes from the buffer to the channel
- truncate(long) – Truncates the file (or other entity) connected to the channel

Reading and Writing Files With Channel I/O shows that the Path.newByteChannel methods return an instance of a SeekableByteChannel. On the default file system, you can use that channel as is, or you can cast it to a FileChannel giving you access to more advanced features, such as mapping a region of the file directly into memory for faster access, locking a region of the file, or reading and writing bytes from an absolute location without affecting the channel's current position.

The following code snippet opens a file for both reading and writing by using one of the newByteChannel methods. The SeekableByteChannel that is returned is cast to a FileChannel. Then, 12 bytes are read from the beginning of the file, and the string "I was here!" is written at that location. The current position in the file is moved to the end, and the 12 bytes from the beginning are appended. Finally, the string, "I was here!" is appended, and the channel on the file is closed.

```java
String s = "I was here!\n";
byte data[] = s.getBytes();
ByteBuffer out = ByteBuffer.wrap(data);

ByteBuffer copy = ByteBuffer.allocate(12);

try (FileChannel fc = (FileChannel.open(file, READ, WRITE))) {
    // Read the first 12
    // bytes of the file.
    int nread;
    do {
        nread = fc.read(copy);
    } while (nread != -1 && copy.hasRemaining());

    // Write "I was here!" at the beginning of the file.
    fc.position(0);
    while (out.hasRemaining())
        fc.write(out);
    out.rewind();

    // Move to the end of the file.  Copy the first 12 bytes to
    // the end of the file.  Then write "I was here!" again.
    long length = fc.size();
    fc.position(length-1);
    copy.flip();
    while (copy.hasRemaining())
        fc.write(copy);
    while (out.hasRemaining())
        fc.write(out);
} catch (IOException x) {
    System.out.println("I/O Exception: " + x);
}
```

### 4.4. Creating and Reading Directories
Some of the methods previously discussed, such as delete, work on files, links and directories. But how do you list all the directories at the top of a file system? How do you list the contents of a directory or create a directory?

This section covers the following functionality specific to directories:

- Listing a File System's Root Directories
- Creating a Directory
- Creating a Temporary Directory
- Listing a Directory's Contents
- Filtering a Directory Listing By Using Globbing
- Writing Your Own Directory Filter
- Walking the File Tree
- Copying a Directory
- Moving a Directory
- Deleting a Directory
- Watching a Directory for Changes

### 4.5. Listing a File System's Root Directories
You can list all the root directories for a file system by using the FileSystem.getRootDirectories method. This method returns an Iterable, which enables you to use the enhanced for statement to iterate over all the root directories.

The following code snippet prints the root directories for the default file system:
```java
Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
for (Path name: dirs) {
System.err.println(name);
}
```
### 4.6. Creating a Directory
You can create a new directory by using the createDirectory(Path, FileAttribute<?>) method. If you don't specify any FileAttributes, the new directory will have default attributes. For example:
```java
Path dir = ...;
Files.createDirectory(path);
```
The following code snippet creates a new directory on a POSIX file system that has specific permissions:
```java
Set<PosixFilePermission> perms =
PosixFilePermissions.fromString("rwxr-x---");
FileAttribute<Set<PosixFilePermission>> attr =
PosixFilePermissions.asFileAttribute(perms);
Files.createDirectory(file, attr);
```
To create a directory several levels deep when one or more of the parent directories might not yet exist, you can use the convenience method, `createDirectories(Path, FileAttribute<?>)`.
 As with the `createDirectory(Path, FileAttribute<?>)` method, you can specify an optional set of initial file attributes. The following code snippet uses default attributes:
```java
Files.createDirectories(Paths.get("foo/bar/test"));
```
The directories are created, as needed, from the top down. In the `foo/bar/test` example, if the foo directory does not exist, it is created. Next, the bar directory is created, if needed, and, finally, the test directory is created.

It is possible for this method to fail after creating some, but not all, of the parent directories.


## 5. Comparison of Java IO, Java NIO, and Java NIO2
Java IO is stream-based and provides a simple API for file and network operations. Java NIO is buffer-based, offering higher performance through channels and buffers, and supports non-blocking I/O and multiplexing. Java NIO2 extends NIO with additional features, including improved file handling and full support for asynchronous I/O.

### Comparison of Java IO, Java NIO, and Java NIO2

| Characteristic        | Java IO                           | Java NIO                                  | Java NIO2                                 |
|-----------------------|-----------------------------------|-------------------------------------------|-------------------------------------------|
| Main Approach         | Stream-based                      | Buffer-based                              | Extension of NIO with additional features |
| Key Components        | InputStream, OutputStream, Reader, Writer | Channels, Buffers, Selectors               | Path, Files, AsynchronousFileChannel      |
| File Handling         | File class                        | FileChannel with ByteBuffer               | Improved file handling with Path and Files classes |
| Asynchronous I/O      | Not supported                     | Partial support through Selectors         | Full support through AsynchronousFileChannel |
| Performance           | Lower compared to NIO             | Higher due to the use of buffers and channels | Similar to NIO, but with additional features |
| Ease of Use           | Simple and straightforward API    | More complex API, requires understanding of buffers and channels | Improved API, makes working with the file system easier |
| Multiplexing          | Not supported                     | Supported through Selectors               | Not directly applicable, but asynchronous operations allow efficient handling of multiple tasks |
| Usage Examples        | Simple file read/write, network connections | Non-blocking I/O, scalable network applications | Asynchronous file read/write, improved file system handling |
| Release Time & Version| Java 1.0                          | Java 1.4 (New I/O)                        | Java 7 (NIO.2)                            |
| Use Cases             | Simple file operations, network I/O | High-performance network applications, scalable I/O | Asynchronous file I/O, improved file system handling |
| Error Handling        | Limited error handling, boolean return values | More comprehensive error handling, exceptions | Improved error handling, exceptions, and file attributes |

