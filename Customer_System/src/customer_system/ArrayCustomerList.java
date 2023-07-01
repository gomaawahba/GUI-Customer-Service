/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer_system;

/**
 *
 * @author DW
 */
public class ArrayCustomerList {
    //======================================= Data Fields=======================
    private static final int MAX_SIZE = 1000;
    private final Customer[] customers_array = new Customer[MAX_SIZE];
    private int top = -1;

    //=================================== No need to make Constructor===========

    //============================== Addition (At end)=========================
    public boolean add(Customer customer) {
        if(isFull()) return false;

        customers_array[++top] = customer;
        return true;
    }

    // =======================Deletion (Name, Contract ID)========================
    public boolean delete(String customer_name) {
        if(isEmpty()) return false;

    // =============================You can use binary search====================
        for(int i = 0; i <= top; i++)
            if(customers_array[i].get_name().equals(customer_name)) {
                for(int j = i; j < top; j++)
                    customers_array[j] = customers_array[j+1];
                top--;
                return true;
            }

        return false;
    }

    public boolean delete(int customer_contract_id) {
        if(isEmpty()) return false;

        for(int i = 0; i <= top; i++)
            if(customers_array[i].get_contract_id() == customer_contract_id) {
                for(int j = i; j < top; j++)
                    customers_array[j] = customers_array[j+1];
                top--;
                return true;
            }

        return false;
    }

    // ========================Access - get() Method============================
    public Customer get(int index) {
        if(index < 0 || index > top) return null;

        return customers_array[index];
    }

    // ==========================Search (Linear, Binary)========================
    public Customer linear_search(String customer_name_or_phone) {
        if(isEmpty()) return null;

        for(int i = 0; i <= top; i++)
            if(customers_array[i].get_name().equals(customer_name_or_phone) ||
               customers_array[i].get_phone().equals(customer_name_or_phone))
                return customers_array[i];

        return null;
    }
//linear_search//////////////////////////////////////////////////////////////////////////////
    public Customer linear_search(int customer_contract_id) {
        if(isEmpty()) return null;

        for(int i = 0; i <= top; i++)
            if(customers_array[i].get_contract_id() == customer_contract_id)
                return customers_array[i];

        return null;
    }

   
//binary_search////////////////////////////////////////////////////////////////////////////
    public Customer binary_search(int customer_contract_id) {
        if(isEmpty()) return null;

        int left = 0, right = top, middle;
        while(left <= right) {
            middle = (left + right) / 2;

            if(customers_array[middle].get_contract_id() == customer_contract_id)
                return customers_array[middle];
            else if(customers_array[middle].get_contract_id() < customer_contract_id)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return null;
    }

    // ==============================Bubble Sort===============================
    public void bubble_sort() {
        for(int pass = 0; pass <= top; pass++)
            for(int step = 0; step < pass; step++)
                if(customers_array[step].compareTo(customers_array[step+1])) {
                    Customer temp = customers_array[step];
                    customers_array[step] = customers_array[step+1];
                    customers_array[step+1] = temp;
                }
    }

    public void bubble_sort_for_id() {
        for(int pass = 0; pass <= top; pass++)
            for(int step = 0; step < pass; step++)
                if(customers_array[step].get_contract_id() < customers_array[step+1].get_contract_id()) {
                    Customer temp = customers_array[step];
                    customers_array[step] = customers_array[step+1];
                    customers_array[step+1] = temp;
                }
    }

    // ============================Selection Sort================================
    public void selection_sort() {
        for(int pass = 0; pass <= top; pass++) {
            int smallest_index = pass;

            for(int index = pass; index <= top; index++) {
                if(customers_array[smallest_index].compareTo(customers_array[index]))
                    smallest_index = index;
            }

            if(smallest_index != pass) {
                Customer temp = customers_array[smallest_index];
                customers_array[smallest_index] = customers_array[pass];
                customers_array[pass] = temp;
            }
        }
    }
// ============================Selection Sort================================
    public void selection_sort_for_id() {
        for(int pass = 1; pass <= top; pass++) {
            int index = pass - 1;
            Customer key = customers_array[pass];

            while(index >= 0 && customers_array[index].get_contract_id() < customers_array[pass].get_contract_id()) {
                customers_array[index+1] = customers_array[index];
                index--;
            }

            customers_array[index+1] = key;
        }
    }

    // ======================Insertion Sort=====================================
    public void insertion_sort() {
        for(int pass = 1; pass <= top; pass++) {
            int index = pass - 1;
            Customer key = customers_array[pass];

            while(index >= 0
                    && customers_array[index].compareTo(customers_array[pass])) {
                customers_array[index+1] = customers_array[index];
                index--;
            }

            customers_array[index+1] = key;
        }
    }

    // =========================Merge Sort======================================
    public void merge_sort(int left, int right) {
        if (left < right) {
            int middle = (right + left) / 2;

            merge_sort(left, middle);
            merge_sort(middle + 1, right);

            merge(left, middle, right);
        }
    }

    // =================merge() Method (Used in Merge Sort)======================
    public void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Customer L[] = new Customer[n1];
        Customer R[] = new Customer[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = customers_array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = customers_array[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (R[j].compareTo(L[i]))
                customers_array[k] = L[i++];
            else
                customers_array[k] = R[j++];
            k++;
        }

        while (i < n1)
            customers_array[k++] = L[i++];

        while (j < n2)
            customers_array[k++] = R[j++];
    }

    // ==============================Heap Sort==================================
    public void heap_sort() {
        int n = top + 1;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);

        for (int i = n - 1; i > 0; i--) {
            Customer temp = customers_array[0];
            customers_array[0] = customers_array[i];
            customers_array[i] = temp;

            heapify(i, 0);
        }
    }

    // =====================heapify() Method (Used in Heap Sort)================
    public void heapify(int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && customers_array[l].compareTo(customers_array[largest]))
            largest = l;

        if (r < n && customers_array[r].compareTo(customers_array[largest]))
            largest = r;

        if (largest != i) {
            Customer swap = customers_array[i];
            customers_array[i] = customers_array[largest];
            customers_array[largest] = swap;

            heapify(n, largest);
        }
    }

    // ======================display() Method (Print out Objects of array)=======
    public void display() {
        for(int index = 0; index <= top; index++)
            System.out.println(customers_array[index].toString());
    }

    // =========================capacity() Method=================================
    public int capacity() {
        return top + 1;
    }

    // =====================isEmpty() Method====================================
    public boolean isEmpty() {
        return top == -1;
    }

    // ========================isFull() Method=================================
    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }
}
