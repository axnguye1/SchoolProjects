--Trieu Huynh & Amanda Nguyen
--4125
--Phase 8, Task 2
CREATE OR REPLACE PROCEDURE Invoice(customer_id VARCHAR2, order_date DATE)
IS
    customer_name CUSTOMER.C_NAME%TYPE;
    total_product_cost NUMBER := 0;
    shipping_cost NUMBER := 10; 
    total_cost NUMBER := 0;
    product_name PRODUCT.P_NAME%TYPE;
    product_quantity LINEITEM.L_QUANTITY%TYPE;
    unit_price PRODUCT.P_PRICE%TYPE;
    line_price NUMBER;
    --cursor for order
  CURSOR order_cursor IS
    SELECT P.P_NAME, LI.L_QUANTITY, P.P_PRICE, LI.L_QUANTITY * P.P_PRICE AS LINE_PRICE
    FROM LINEITEM LI
    JOIN ORDERS O ON LI.L_OID = O.O_ID
    JOIN PRODUCT P ON LI.L_PID = P.P_ID
    WHERE O.C_ID = customer_id AND O.O_DATE =order_date;
  v_customer_count NUMBER;
BEGIN
  BEGIN
  --check If Customer exists
    SELECT C_NAME INTO customer_name
    FROM CUSTOMER
    WHERE C_ID = customer_id;
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Error: Customer not found for ID: ' || customer_id);
      RETURN;
  END;
  --check if there is an order to the order date for customer.
  SELECT COUNT(*) INTO v_customer_count
  FROM ORDERS
  WHERE C_ID = customer_id AND O_DATE =order_date;
  IF v_customer_count = 0 THEN
    DBMS_OUTPUT.PUT_LINE('No invoice to generate for Customer ID: ' || customer_id);
    RETURN;
  END IF;
  --header
  OPEN order_cursor;
  DBMS_OUTPUT.PUT_LINE(TO_CHAR(order_date, 'YYYY-MM-DD') || ' Invoice for ' || customer_id || ': ' || customer_name);
  DBMS_OUTPUT.PUT_LINE(RPAD('Product', 20) || RPAD('Quantity', 10) || RPAD('Unit Price', 15) || RPAD('Total', 15));
  DBMS_OUTPUT.PUT_LINE('--------------------------------------------------');
  BEGIN
    LOOP
      FETCH order_cursor INTO product_name, product_quantity, unit_price, line_price;
      EXIT WHEN order_cursor%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(RPAD(product_name, 20) || RPAD(TO_CHAR(product_quantity), 10) || RPAD('$' || TO_CHAR(unit_price, '99999.99'), 15) || RPAD('$' || TO_CHAR(line_price, '99999.99'), 15));
      total_product_cost := total_product_cost + line_price;
      IF unit_price >= 35 THEN
        shipping_cost := 0; 
      END IF;
    END LOOP;
  EXCEPTION
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error fetching data: ' || SQLERRM);
  END;
  CLOSE order_cursor;
  --total's
DBMS_OUTPUT.PUT_LINE('Total Product Cost: $' || LPAD(TO_CHAR(total_product_cost, '99999.99'), 10));
DBMS_OUTPUT.PUT_LINE('Shipping Cost: $' || LPAD(TO_CHAR(shipping_cost, '99999.99'), 14));
total_cost := total_product_cost + shipping_cost;
DBMS_OUTPUT.PUT_LINE('Total Cost: $' || LPAD(TO_CHAR(total_cost, '99999.99'), 17));
END Invoice;
/
