/*
 * Feel free to use anything : )  */
package javafxapplication1.service;

/**
 * This class should be the parent of all simulation algorithms
 * it contains process life cycle
 *
 * @author YahyaShqair
 */
public abstract class Algorithm {
    /**
     * Each algorithm should store results and details on it.
     */
    public ProcessInWork[] processResultList;

    /**
     * This function used to start simulation part and the output should be in processResultList.
     */
    public abstract void run();
}
