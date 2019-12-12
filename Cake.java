package coffee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Cake extends JFrame {
	 public static final String SOURCE = "./src/main/resources/data/";
	 public static final String COFFEE_NS = "http://www.semanticweb.org/shruthi/ontologies/2019/10/untitled-ontology-4#";

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 * 
	 */
	//public static Cake frame = new  Cake();
	private JScrollPane sp=new JScrollPane();
	
	public static Cake frame = new  Cake();
	private JTextField txtByName;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	Cake frame = new Cake();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cake() {
		setTitle("Cake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 423);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(502, 177, 94, 51);
		contentPane.add(btnNewButton);
		//JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(456, 177, 140, 51);
		btnNewButton.setFocusPainted(false);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CAKE = txtByName.getText().toString().toLowerCase();
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				//read ontology model
				FileManager.get().readModel( m, SOURCE + "coffee.owl" );
				
				String prefix = "prefix Cake: <" + COFFEE_NS + ">\n" +
		                		"prefix rdfs: <" + RDFS.getURI() + ">\n" +
		                		"prefix owl: <" + OWL.getURI() + ">\n";

				String query_text=  prefix +
      " SELECT ?Sponge_flavour (COUNT(*) as ?count) \r\n" +
								" WHERE {?x a Cake:Cake. ?x Cake:Sponge_flavour ?Sponge_flavour \r\n}";
				query_text += " GROUP BY (?Sponge_flavour)";
				query_text+=	"HAVING (COUNT(*)>1)";
			    query_text += " ORDER BY ASC(?name) ";
				System.out.println(query_text);
				Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		       
		        /*************************************** Create Arrays for Table Headers and Table Values **********************************/ 
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();
                columns.add(" Sponge_flavour");
		          /*******************************************************************************************************************************/
		       try {
		            ResultSet results = qexec.execSelect();
		            int i = 0;
		            while ( results.hasNext() ) {
		                QuerySolution qs = results.next();  
		                /****************************  Assign query data to array. That will populate JTable **************************/
		                values.add(new String[] {qs.get("Sponge_flavour").toString()});
		               /**************************************************************************************************************/
		                  System.out.println(qs.get("name"));
		                i++;
		            }
		            
		         /*************************Create Table and tableModel******************************/
		            TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		            JTable table = new JTable(tableModel);
		            table.setForeground(Color.DARK_GRAY);
		            table.setBackground(Color.WHITE);
		            table.setRowHeight(35);
		           sp.setViewportView(table);		           
		            sp.setBounds(60, 250, 570, 317);
		         contentPane.add(sp);
		            contentPane.repaint();
		          /*********************************************************************************/
		        }
		        finally {
		            qexec.close();
		        }

			}
		});
		
		contentPane.setLayout(null);
		btnNewButton.setPreferredSize(new Dimension(350, 45));
		contentPane.add(btnNewButton);
		
		//JLabel lblDrinksAndFood_1 = new JLabel("");
		//lblDrinksAndFood_1 .setForeground(new Color(0, 128, 128));
	//	lblDrinksAndFood_1 .setFont(new Font("Sitka Small", Font.BOLD, 31));
	//	lblDrinksAndFood_1 .setBounds(212, 106, 238, 45);
	//	contentPane.add(lblDrinksAndFood_1 );
		
		txtByName = new JTextField();
		txtByName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtByName.setToolTipText("Enter Name");
		txtByName.setBounds(407, 89, 215, 36);
		contentPane.add(txtByName);
		txtByName.setColumns(10);
		
		JLabel lblCake = new JLabel("CAKE");
		lblCake.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCake.setBounds(485, 23, 79, 36);
		contentPane.add(lblCake);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shruthi\\Desktop\\images\\cake image.JPG"));
		lblNewLabel.setBounds(10, 11, 387, 234);
		contentPane.add(lblNewLabel);
		
	}
}
