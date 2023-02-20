import java.util.Scanner;
// import minidb.xmlParser.DatabaseFile;
// import minidb.xmlParser.RegistryFile;
// import constants.*;

/*
To do
- Comment the code
- Table Layout for the data.
- usage of threads
*/

/**
 * Javadoc comments. All are static methods because we are not creating any
 * object of this class.
 * 
 * @author Chanakya
 */
public class cli {

    /**
     * The Registry File is a XML file which contains the information about the all
     * the databases created. It acts as a pointer to the Database File. So, We
     * instantly load the registry file.
     */
    static RegistryFile registry = RegistryFile.getInstance(constants.DATA_XML_PATH);


    /**
     * This attribute is for storing the DatabaseFile instance. Which is assigned
     * when the user calls the command "use". if the user does not call the command
     * "use" then the We show a error message.
     */
    static DatabaseFile CurrentDb;

    public static void main(String[] args) {                        //main alada korbo
        print(constants.HEADING);

        // registry = new RegistryFile(constants.DATA_XML_PATH);      //singleton
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print(constants.CMD_PREFIX);

            String currentCmd = input.nextLine();

            // break if user wants to exit
            if (currentCmd.equals("exit;")) {
                break;
            }
            long startTime = System.nanoTime();
            cliInputs(currentCmd);
            long endTime = System.nanoTime();

            long exeTime = (endTime - startTime) / 1000000;
            print("\nExecution Time: " + exeTime + "ms");
        }

        input.close();
    }


    //method extraction
    private static void cliInputs(String input) {
        String[] cmdArgs = input.split(" ");
    
        switch (cmdArgs[0]) {
            case "new":
                handleNewCommand(cmdArgs);
                break;
            case "use":
                handleUseCommand(cmdArgs);
                break;
            case "list":
                handleListCommand();
                break;
            case "help;":
                handleHelpCommand();
                break;
            case "info":
                handleInfoCommand();
                break;
            case "schema":
                handleSchemaCommand(cmdArgs);
                break;
            case "add":
                handleAddCommand(cmdArgs);
                break;
            case "read":
                handleReadCommand(cmdArgs);
                break;
            case "drop":
                handleDropCommand(cmdArgs);
                break;
            case "update":
                handleUpdateCommand(cmdArgs);
                break;
            case "delete":
                handleDeleteCommand(cmdArgs);
                break;
            default:
                print("UNKNOWN COMMAND: " + cmdArgs[0] + "\nType `help;` for commands list");
                break;
        }
    }
    
    private static void handleNewCommand(String[] cmdArgs) {
        registry.createNewDatabase(cmdArgs[1]);
    }
    
    private static void handleUseCommand(String[] cmdArgs) {
        String path = registry.getDatabasePath(cmdArgs[1], false);
    
        if (path != null) {
            CurrentDb = new DatabaseFile(path);
            CurrentDb.EditMode();
            print("Successfully loaded Database named: " + cmdArgs[1]);
        } else {
            print("Database not found");
        }
    }
    
    private static void handleListCommand() {
        registry.listAllDatabases();
    }
    
    private static void handleHelpCommand() {
        print(constants.HELP_COMMANDS);
    }
    
    private static void handleInfoCommand() {
        // For querying the meta info of the database
        // TODO
    }
    
    private static void handleSchemaCommand(String[] cmdArgs) {
        if (CurrentDb != null) {
            String xy = cmdArgs[1];
    
            if (xy.equals("show")) {
                print(CurrentDb.getSchema());
            } else {
                String[] schemaVals = xy.split(",");
                if (schemaVals.length > 1) {
                    CurrentDb.createSchema(xy);
                } else {
                    print("There should be atleast 2 columns of data");
                }
            }
    
        } else {
            print(errors.NO_DATABASE_SELECTED);
        }
    }
    
    private static void handleAddCommand(String[] cmdArgs) {
        if (CurrentDb != null) {
            CurrentDb.addData(cmdArgs[1]);
        } else {
            print(errors.NO_DATABASE_SELECTED);
        }
    }
    
    private static void handleReadCommand(String[] cmdArgs) {
        if (CurrentDb != null) {
            if (cmdArgs.length == 1) {
                CurrentDb.readData();
            } else {
                CurrentDb.readData(cmdArgs[1]);
            }
        } else {
            print(errors.NO_DATABASE_SELECTED);
        }
    }
    
    private static void handleDropCommand(String[] cmdArgs) {
        registry.deleteDatabase(cmdArgs[1]);
    }
    
    private static void handleUpdateCommand(String[] cmdArgs) {
        // TODO
        if (CurrentDb != null) {
        }
    }
    
    private static void handleDeleteCommand(String[] cmdArgs) {
        if (CurrentDb != null) {
            CurrentDb.deleteData(cmdArgs[1]);
        } else {
            print(errors.NO_DATABASE_SELECTED);
        }
    }
    

    private static void print(String x) {
        System.out.println(x);
    }
}

// Commands that are available
// ✅ read
// ✅ read id=2
// read id=8..99

// ✅ add 04,cow,25

// ✅ delete id=2
// delete id=5..7

// ✅ schema id, name, age
// schema update id, name,age
// ✅ schema show

// The hardest one:
// update name='cow' where id=2

// Future:
// - import/export databases cmds